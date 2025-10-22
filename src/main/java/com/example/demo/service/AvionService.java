package com.example.demo.service;

import com.example.demo.model.Avion;
import com.example.demo.respository.AvionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionService {
    private final AvionRepository repo;
    public AvionService(AvionRepository repo){ this.repo = repo; }

    public List<Avion> listAll(){ return repo.findAll(); }
    public Avion get(Integer id){ return repo.findById(id); }
    @Transactional
    public Avion create(Avion a){ return repo.save(a); }
    @Transactional public Avion update(Avion a){ repo.update(a); return a; }
    @Transactional public void delete(Integer id){ repo.delete(id); }
}