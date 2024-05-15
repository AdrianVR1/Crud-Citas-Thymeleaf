package com.citas.controllers;

import com.citas.models.entity.Doctor;
import com.citas.models.entity.Especialidad;
import com.citas.models.service.DoctorService;
import com.citas.models.service.EspecialidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/listadoDoctor")
    public String listar(Model model, @Param("buscarDoc") String buscarDoc) {
        List<Doctor>listadoDoc = doctorService.buscarDoc(buscarDoc);
        model.addAttribute("listadoDoc", listadoDoc);
        model.addAttribute("buscarDoc", buscarDoc);
        return "/indexDoctor";
    }

    @GetMapping("/nuevoDoctor")
    public String nuevo(Model model) {
        model.addAttribute("doctor", new Doctor());
        List<Especialidad>listarEsp = especialidadService.listarEsp();
        model.addAttribute("listaEsp",listarEsp);
        return "nuevoDoctor";
    }

    @PostMapping("/guardardoc")
    public String guardar(@Valid @ModelAttribute Doctor doc, BindingResult result,  Model model) {
        if(result.hasErrors()) {
            List<Especialidad> listarEsp = especialidadService.listarEsp();
           model.addAttribute("listaEsp", listarEsp);
            return "nuevoDoctor";
        }
        doctorService.guardarDoc(doc);
        return "redirect:/listadoDoctor";
    }

    @GetMapping("/editardoc/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Doctor>listaDoc = doctorService.buscarId(id);
        List<Especialidad>listarEsp = especialidadService.listarEsp();
        model.addAttribute("doctor",listaDoc);
        model.addAttribute("listaEsp",listarEsp);
        return "/nuevoDoctor";
    }

    @GetMapping("/borrardoc/{id}")
    public String borrar(@PathVariable int id) {
        doctorService.borrar(id);
        return "redirect:/listadoDoctor";
    }

}
