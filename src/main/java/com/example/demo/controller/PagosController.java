package com.example.demo.controller;

import com.example.demo.dto.PagoRequest;
import com.example.demo.dto.PagoResponse;
import com.example.demo.service.PagadorService;
import com.example.demo.service.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/Pagos")
public class PagosController {

    private final PagosService pagoService;

    public PagosController(PagosService pagoService) {
        this.pagoService = pagoService;
    }


    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        List<PagoResponse> data = pagoService.getAll();

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Lista de pagos obtenida correctamente");
        response.put("data", data);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable int id) {
        try {
            PagoResponse pago = pagoService.getById(id);

            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", LocalDateTime.now());
            response.put("status", HttpStatus.OK.value());
            response.put("message", "Pago encontrado");
            response.put("data", pago);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", LocalDateTime.now());
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("message", "Pago no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody PagoRequest request) {
        pagoService.create(request);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Pago creado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable int id, @RequestBody PagoRequest request) {
        request.setIdPago(id);
        pagoService.update(request);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Pago actualizado exitosamente");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) {
        pagoService.delete(id);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.OK.value());
        response.put("message", "Pago eliminado exitosamente");

        return ResponseEntity.ok(response);
    }

}
