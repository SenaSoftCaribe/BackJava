package com.example.demo.controller;

import com.example.demo.dto.PasajeroRequest;
import com.example.demo.dto.PasajeroResponse;
import com.example.demo.respository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroController {

    private final PasajeroRepository repository;

    @Autowired
    public PasajeroController(PasajeroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<PasajeroResponse>> obtenerTodos() {
        return ResponseEntity.ok(repository.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasajeroResponse> obtenerPorId(@PathVariable int id) {
        Optional<PasajeroResponse> pasajero = repository.obtenerPorId(id);
        return pasajero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> crearPasajero(@RequestBody PasajeroRequest request) {
        repository.crearPasajero(request);
        return ResponseEntity.status(201).body("Pasajero creado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarPasajero(@PathVariable int id, @RequestBody PasajeroRequest request) {
        int rows = repository.actualizarPasajero(id, request);
        if (rows > 0) {
            return ResponseEntity.ok("Pasajero actualizado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPasajero(@PathVariable int id) {
        int rows = repository.eliminarPasajero(id);
        if (rows > 0) {
            return ResponseEntity.ok("Pasajero eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
