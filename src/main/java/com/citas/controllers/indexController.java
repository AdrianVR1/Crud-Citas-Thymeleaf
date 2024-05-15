package com.citas.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class indexController {
    @GetMapping("/")
    private String index() {
        return "/index";
    }
}
