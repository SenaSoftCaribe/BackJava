package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {
    private final AdminRepository repo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AdminService(AdminRepository repo) { this.repo = repo; }

    @Transactional
    public Admin create(String nombre, String plaintextPassword, String correo) {
        Admin a = new Admin();
        a.setNombreAdmin(nombre);
        a.setPasswordHash(passwordEncoder.encode(plaintextPassword));
        a.setCorreo(correo);
        return repo.save(a);
    }

    public Admin findById(Integer id) { return repo.findById(id); }
    public Admin findByCorreo(String correo) { return repo.findByCorreo(correo); }

    @Transactional
    public void delete(Integer id) { repo.delete(id); }
}
