package com.example.demo.service;

import com.example.demo.model.PagoReserva;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoReservaService {

    private final com.example.demo.repository.PagoReservaRepository repo;
    public PagoReservaService(com.example.demo.repository.PagoReservaRepository repo) { this.repo = repo; }



    public List<PagoReserva> listAll() { return repo.findAll(); }
    public PagoReserva get(Integer id) { return repo.findById(id); }

    @Transactional
    public PagoReserva create(PagoReserva p) { return repo.save(p); }

    @Transactional
    public void delete(Integer id) { repo.delete(id); }
}
