package com.example.demo.service;


import com.example.demo.dto.ReservaRequest;
import com.example.demo.dto.ReservaResponse;
import com.example.demo.respository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepositorio;

    public ReservaService(ReservaRepository reservaRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
    }

    public List<ReservaResponse> getAll() {
        return reservaRepositorio.findAll();
    }

    public ReservaResponse getById(int id) {
        return reservaRepositorio.findById(id);
    }

    public void create(ReservaRequest request) {
        reservaRepositorio.save(request);
    }

    public void update(ReservaRequest request) {
        reservaRepositorio.update(request);
    }

    public void delete(int id) {
        reservaRepositorio.delete(id);
    }
}
