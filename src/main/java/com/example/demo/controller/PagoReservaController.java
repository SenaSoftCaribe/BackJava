package com.example.demo.controller;

import com.example.demo.dto.PagoReservaRequest;
import com.example.demo.dto.PagoReservaResponse;
import com.example.demo.model.PagoReserva;

import com.example.demo.service.PagoReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pagosreserva")
public class PagoReservaController {
    private final PagoReservaService service;

    public PagoReservaController(PagoReservaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        List<PagoReservaResponse> data = service.getAll();
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 200);
        response.put("message", "Pagos de reserva obtenidos");
        response.put("data", data);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable int id) {
        try {
            PagoReservaResponse pago = service.getById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", LocalDateTime.now());
            response.put("status", 200);
            response.put("message", "Pago reserva encontrado");
            response.put("data", pago);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", LocalDateTime.now());
            response.put("status", 404);
            response.put("message", "No se encontró el pago de reserva con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody PagoReservaRequest request) {
        service.create(request);
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 201);
        response.put("message", "Pago de reserva creado correctamente");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable int id, @RequestBody PagoReservaRequest request) {
        request.setIdPagosReserva(id);
        service.update(request);
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 200);
        response.put("message", "Pago de reserva actualizado correctamente");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) {
        service.delete(id);
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 200);
        response.put("message", "Pago de reserva eliminado correctamente");
        return ResponseEntity.ok(response);
    }
}