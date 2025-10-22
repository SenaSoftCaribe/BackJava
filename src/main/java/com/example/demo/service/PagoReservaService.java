package com.example.demo.service;

import com.example.demo.dto.PagoReservaRequest;
import com.example.demo.dto.PagoReservaResponse;
import com.example.demo.model.PagoReserva;

import com.example.demo.respository.PagoReservaRepository;
import com.example.demo.respository.PagosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoReservaService {
    ;private final PagoReservaRepository reservaRepositorio;

    public PagoReservaService(PagoReservaRepository reservaRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
    }


    public List<PagoReservaResponse> getAll() {
        return reservaRepositorio.findAll();
    }

    public PagoReservaResponse getById(int id) {
        return reservaRepositorio.findById(id);
    }

    public void create(PagoReservaRequest request) {
        reservaRepositorio.save(request);
    }

    public void update(PagoReservaRequest request) {
        reservaRepositorio.update(request);
    }

    public void delete(int id) {
        reservaRepositorio.delete(id);
    }
}
