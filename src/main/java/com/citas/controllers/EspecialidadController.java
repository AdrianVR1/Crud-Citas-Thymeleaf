package com.citas.controllers;

import com.citas.models.entity.Especialidad;
import com.citas.models.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EspecialidadController {

    @Autowired
    private EspecialidadService service;


    @GetMapping("/listadoEspecialidad")
    private String listar(Model modelo) {
        List<Especialidad>listarEsp = service.listarEsp();
        modelo.addAttribute("listadoEsp",listarEsp);
        return "/indexEspecialidad";
    }
}
