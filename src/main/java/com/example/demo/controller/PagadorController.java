package com.example.demo.controller;

import com.example.demo.dto.PagadorRequest;
import com.example.demo.dto.PagadorResponse;
import com.example.demo.service.PagadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pagadores")
public class PagadorController {

    private final PagadorService pagadorService;

    public PagadorController(PagadorService pagadorService) {
        this.pagadorService = pagadorService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        List<PagadorResponse> data = pagadorService.getAll();

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Lista de pagadores obtenida correctamente");
        response.put("data", data);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable int id) {
        try {
            PagadorResponse pagador = pagadorService.getById(id);

            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", LocalDateTime.now());
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Pagador encontrado");
            response.put("data", pagador);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", LocalDateTime.now());
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("message", "Pagador no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody PagadorRequest request) {
        pagadorService.create(request);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Pagador creado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable int id, @RequestBody PagadorRequest request) {
        request.setIdPagador(id);
        pagadorService.update(request);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Pagador actualizado exitosamente");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) {
        pagadorService.delete(id);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Pagador eliminado exitosamente");

        return ResponseEntity.ok(response);
    }
}