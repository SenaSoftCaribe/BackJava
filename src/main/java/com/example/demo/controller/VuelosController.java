package com.example.demo.controller;

import com.example.demo.dto.VuelosRequest;
import com.example.demo.model.Vuelos;
import com.example.demo.service.VuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.VuelosResponse;
import java.util.List;

public class VuelosController{

    private final VuelosService service;

    @Autowired
    public VuelosController(VuelosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VuelosResponse>> obtenerTodos() {
        List<Vuelos> lista = service.obtenerTodos();
        List<VuelosResponse> respuesta = lista.stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VuelosResponse> obtenerPorId(@PathVariable int id) {
        try {
            Vuelos vuelo = service.obtenerPorId(id);
            return ResponseEntity.ok(toResponse(vuelo));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VuelosResponse> crearVuelo(@RequestBody VuelosRequest request) {
        Vuelos creado = service.crearVuelo(toEntity(request));
        return ResponseEntity.ok(toResponse(creado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VuelosResponse> actualizarVuelo(@PathVariable int id, @RequestBody VuelosRequest request) {
        Vuelos vuelo = toEntity(request);
        vuelo.setIdVuelo(id);
        try {
            Vuelos actualizado = service.actualizarVuelo(vuelo);
            return ResponseEntity.ok(toResponse(actualizado));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable int id) {
        try {
            service.eliminarVuelo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
