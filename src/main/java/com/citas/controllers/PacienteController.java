package com.citas.controllers;

import com.citas.models.entity.Paciente;
import com.citas.models.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PacienteController {
    @Autowired
    private PacienteService service;

    @GetMapping("/listadoPacientes")
    public String listar(Model modelo, @Param("palabraClave") String palabraClave) {
        List<Paciente> listar = service.listarpac(palabraClave);
        modelo.addAttribute("listado",listar);
        modelo.addAttribute("palabraClave", palabraClave);
        return "/indexPacientes";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model modelo) {
        modelo.addAttribute("paciente", new Paciente());
        return "nuevoPaciente";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Paciente paciente, BindingResult result) {
        if(result.hasErrors()) {
        return "nuevoPaciente";
        }
        service.guardar(paciente);
        return "redirect:/listadoPacientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model modelo){
        Optional<Paciente>listapac = service.buscarId(id);
        modelo.addAttribute("paciente", listapac);
        return "nuevoPaciente";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable int id) {
        service.borrar(id);
        return "redirect:/listadoPacientes";
    }


}
