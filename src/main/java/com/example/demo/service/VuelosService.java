package com.example.demo.service;

import com.example.demo.dto.VuelosRequest;
import com.example.demo.dto.VuelosResponse;
import com.example.demo.model.Vuelos;

import com.example.demo.respository.VuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VuelosService {

    private final VuelosRepository repository;

    @Autowired
    public VuelosService(VuelosRepository repository) {
        this.repository = repository;
    }

    public List<VuelosResponse> obtenerTodos() {
        return repository.obtenerTodos();
    }

    public VuelosResponse obtenerPorId(int id) {
        return repository.obtenerPorId(id).orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
    }

    public void crearVuelo(VuelosRequest req) {
        repository.crearVuelo(req);
    }

    public void actualizarVuelo(int id, VuelosRequest req) {
        int filasActualizadas = repository.actualizarVuelo(id, req);
        if (filasActualizadas == 0) {
            throw new RuntimeException("Vuelo no encontrado para actualizar");
        }
    }

    public void eliminarVuelo(int id) {
        int filasEliminadas = repository.eliminarVuelo(id);
        if (filasEliminadas == 0) {
            throw new RuntimeException("Vuelo no encontrado para eliminar");
        }
    }
}


