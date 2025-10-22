package com.example.demo.controller;


import com.example.demo.dto.AvionRequest;
import com.example.demo.dto.AvionResponse;
import com.example.demo.model.Avion;
import com.example.demo.service.AvionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aviones")
public class AvionController {
    private final AvionService service;
    public AvionController(AvionService service){ this.service = service; }

    private AvionResponse toResp(Avion a){
        AvionResponse r = new AvionResponse();
        r.setIdAvion(a.getIdAvion()); r.setModelo(a.getModelo()); r.setMarca(a.getMarca());
        r.setAsientos(a.getAsientos()); r.setEstado(a.getEstado()); return r;
    }
    private Avion toEntity(AvionRequest req){
        Avion a = new Avion();
        a.setModelo(req.getModelo()); a.setMarca(req.getMarca()); a.setAsientos(req.getAsientos()); a.setEstado(req.getEstado());
        return a;
    }

    @GetMapping
    public List<AvionResponse> all(){ return service.listAll().stream().map(this::toResp).collect(Collectors.toList()); }

    @GetMapping("/{id}") public ResponseEntity<AvionResponse> get(@PathVariable Integer id){
        try { return ResponseEntity.ok(toResp(service.get(id))); } catch(Exception e){ return ResponseEntity.notFound().build(); }
    }

    @PostMapping public ResponseEntity<AvionResponse> create(@Valid @RequestBody AvionRequest req){
        Avion created = service.create(toEntity(req));
        return ResponseEntity.created(URI.create("/api/aviones/" + created.getIdAvion())).body(toResp(created));
    }

    @PutMapping("/{id}") public ResponseEntity<AvionResponse> update(@PathVariable Integer id, @Valid @RequestBody AvionRequest req){
        Avion a = toEntity(req); a.setIdAvion(id); service.update(a); return ResponseEntity.ok(toResp(a));
    }

    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Integer id){ service.delete(id); return ResponseEntity.noContent().build(); }
}