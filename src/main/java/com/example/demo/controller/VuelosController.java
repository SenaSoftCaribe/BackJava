package com.example.demo.controller;

import com.example.demo.dto.VuelosRequest;
import com.example.demo.dto.VuelosResponse;
import com.example.demo.model.Vuelos;
import com.example.demo.service.VuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/vuelos")
public class VuelosController {

    private final VuelosService service;

    @Autowired
    public VuelosController(VuelosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VuelosResponse>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VuelosResponse> obtenerPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.obtenerPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> crearVuelo(@RequestBody VuelosRequest request) {
        service.crearVuelo(request);

        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Vuelo creado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarVuelo(@PathVariable int id, @RequestBody VuelosRequest request) {
        try {
            service.actualizarVuelo(id, request);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable int id) {
        try {
            service.eliminarVuelo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
