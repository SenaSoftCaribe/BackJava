package com.example.demo.controller;

import com.example.demo.dto.PasajeroRequest;
import com.example.demo.dto.PasajeroResponse;
import com.example.demo.respository.PasajeroRepository;
import com.example.demo.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {


    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping
    public List<PasajeroResponse> obtenerTodos() {
        return pasajeroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<PasajeroResponse> obtenerPorId(@PathVariable int id) {
        return pasajeroService.obtenerPorId(id);
    }

    @PostMapping
    public String crearPasajero(@RequestBody PasajeroRequest req) {
        return pasajeroService.crearPasajero(req);
    }

    @PutMapping("/{id}")
    public int actualizarPasajero(@PathVariable int id, @RequestBody PasajeroRequest req) {
        return pasajeroService.actualizarPasajero(id, req);
    }

    @DeleteMapping("/{id}")
    public int eliminarPasajero(@PathVariable int id) {
        return pasajeroService.eliminarPasajero(id);
    }

}
