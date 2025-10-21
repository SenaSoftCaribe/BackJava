package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prueba {

    @GetMapping("/hello")
    public String saludar() {
        return "Hola GUAPO";
    } }