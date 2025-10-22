package com.example.demo.controller;

import com.example.demo.dto.AdminRequest;
import com.example.demo.dto.AdminResponse;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<String> crearAdmin(@RequestBody AdminRequest admin) {
        adminService.crearAdmin(admin);
        return ResponseEntity.ok("Admin creado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> obtenerAdmin(@PathVariable int id) {
        return ResponseEntity.ok(adminService.obtenerAdmin(id));
    }

    @GetMapping
    public ResponseEntity<List<AdminResponse>> listarAdmins() {
        return ResponseEntity.ok(adminService.obtenerTodosLosAdmins());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAdmin(@PathVariable int id, @RequestBody AdminRequest admin) {
        admin.setIdAdmin(id);
        adminService.actualizarAdmin(admin);
        return ResponseEntity.ok("Admin actualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAdmin(@PathVariable int id) {
        adminService.eliminarAdmin(id);
        return ResponseEntity.ok("Admin eliminado");
    }

    /// /login

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        AdminResponse admin = adminService.login(loginRequest.getCorreo(), loginRequest.getPasswordAdmin());

        if (admin != null) {
            // 🔹 Respuesta personalizada con mensaje + datos del admin
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Ingreso exitoso");
            response.put("admin", admin);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas");
        }
    }
}