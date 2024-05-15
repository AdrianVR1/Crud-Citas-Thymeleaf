package com.citas.controllers;


import com.citas.models.entity.Cita;
import com.citas.models.entity.Doctor;
import com.citas.models.entity.Especialidad;
import com.citas.models.entity.Paciente;
import com.citas.models.service.CitaService;
import com.citas.models.service.DoctorService;
import com.citas.models.service.EspecialidadService;
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
public class CitaController {
    @Autowired
    private CitaService citaService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/listadoCita")
    private String listar(Model modelo, @Param("buscarCita") String buscarCita) {
        List<Cita>listaCit = citaService.buscarCit(buscarCita);
        modelo.addAttribute("listadoCit",listaCit);
        modelo.addAttribute("buscarCit",buscarCita);
        return "/indexCitas";
    }

    @GetMapping("/nuevaCita")
    private String nuevo(Model modelo) {
        modelo.addAttribute("cita", new Cita());
        List<Paciente>listaPac = pacienteService.listar();
        modelo.addAttribute("listadoPac",listaPac);
        List<Doctor>listaDoc = doctorService.listarDoc();
        modelo.addAttribute("listadoDoc",listaDoc);
        List<Especialidad>listaEsp = especialidadService.listarEsp();
        modelo.addAttribute("listadoEsp", listaEsp);
        return "nuevaCita";
    }

    @PostMapping("/guardarcit")
    private String guardar(@Valid @ModelAttribute Cita cita, BindingResult result, Model modelo) {
        if (result.hasErrors()) {
            List<Paciente>listaPac = pacienteService.listar();
            modelo.addAttribute("listadoPac",listaPac);
            List<Doctor>listaDoc = doctorService.listarDoc();
            modelo.addAttribute("listadoDoc",listaDoc);
            List<Especialidad>listaEsp = especialidadService.listarEsp();
            modelo.addAttribute("listadoEsp", listaEsp);
            return "nuevaCita";
        }
        citaService.guardarCit(cita);
        return "redirect:/listadoCita";
    }

    @GetMapping("/editarcita/{id}")
    public String editar(@PathVariable int id, Model modelo) {
        Optional<Cita>listaCit = citaService.buscarId(id);
        modelo.addAttribute("cita",listaCit);
        List<Paciente>listaPac = pacienteService.listar();
        modelo.addAttribute("listadoPac",listaPac);
        List<Doctor>listaDoc = doctorService.listarDoc();
        modelo.addAttribute("listadoDoc",listaDoc);
        List<Especialidad>listaEsp = especialidadService.listarEsp();
        modelo.addAttribute("listadoEsp", listaEsp);
        return "/nuevaCita";
    }

    @GetMapping("/borrarcita/{id}")
    public String borrar(@PathVariable int id) {
        citaService.borrar(id);
        return "redirect:/listadoCita";
    }
}
