package com.example.demo.controller;

import com.example.demo.dto.PagoReservaRequest;
import com.example.demo.dto.PagoReservaResponse;
import com.example.demo.model.PagoReserva;

import com.example.demo.service.PagoReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagos-reserva")
public class PagoReservaController {
    @Autowired
    private PagoReservaService service;

    private PagoReservaResponse toResp(PagoReserva p) {
        PagoReservaResponse r = new PagoReservaResponse();
        r.setIdPagosReserva(p.getIdPagosReserva());
        r.setTipoPago(p.getTipoPago());
        r.setFecha(p.getFecha());
        r.setReservaId(p.getReservaId());
        r.setPagadorId(p.getPagadorId());
        r.setMonto(p.getMonto());
        return r;
    }

    private PagoReserva toEntity(PagoReservaRequest req) {
        PagoReserva p = new PagoReserva();
        p.setTipoPago(req.getTipoPago());
        p.setReservaId(req.getReservaId());
        p.setPagadorId(req.getPagadorId());
        p.setMonto(req.getMonto());
        return p;
    }

    @GetMapping public List<PagoReservaResponse> all() {
        return service.listAll().stream().map(this::toResp).collect(Collectors.toList());
    }

    @GetMapping("/{id}") public ResponseEntity<PagoReservaResponse> get(@PathVariable Integer id) {
        try { return ResponseEntity.ok(toResp(service.get(id))); } catch(Exception e) { return ResponseEntity.notFound().build(); }
    }

    @PostMapping public ResponseEntity<PagoReservaResponse> create(@Valid @RequestBody PagoReservaRequest req) {
        PagoReserva created = service.create(toEntity(req));
        return ResponseEntity.created(URI.create("/api/pagos-reserva/" + created.getIdPagosReserva())).body(toResp(created));
    }

    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Integer id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
