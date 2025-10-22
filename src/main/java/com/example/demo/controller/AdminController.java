package com.example.demo.controller;

import com.example.demo.dto.AdminRequest;
import com.example.demo.dto.AdminResponse;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService service;
    public AdminController(AdminService service) { this.service = service; }

    private AdminResponse toResp(Admin a) {
        AdminResponse r = new AdminResponse();
        r.setIdAdmin(a.getIdAdmin());
        r.setNombreAdmin(a.getNombreAdmin());
        r.setCorreo(a.getCorreo());
        return r;
    }

    @PostMapping
    public ResponseEntity<AdminResponse> create(@Valid @RequestBody AdminRequest req) {
        Admin created = service.create(req.getNombreAdmin(), req.getPassword(), req.getCorreo());
        return ResponseEntity.created(URI.create("/api/admins/" + created.getIdAdmin())).body(toResp(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> get(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(toResp(service.findById(id)));
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
