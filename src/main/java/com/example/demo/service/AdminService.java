package com.example.demo.service;

import com.example.demo.dto.AdminRequest;
import com.example.demo.dto.AdminResponse;
import com.example.demo.model.Admin;

import com.example.demo.respository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminDAO;

    public void crearAdmin(AdminRequest admin) {
        adminDAO.createAdmin(admin);
    }

    public AdminResponse obtenerAdmin(int id) {
        return adminDAO.getAdminById(id);
    }

    public List<AdminResponse> obtenerTodosLosAdmins() {
        return adminDAO.getAllAdmins();
    }

    public void actualizarAdmin(AdminRequest admin) {
        adminDAO.updateAdmin(admin);
    }

    public void eliminarAdmin(int id) {
        adminDAO.deleteAdmin(id);
    }
}
