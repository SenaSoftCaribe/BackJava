package com.example.demo.service;

import com.example.demo.dto.PasajeroRequest;
import com.example.demo.dto.PasajeroResponse;
import com.example.demo.respository.PasajeroRepository;
import com.example.demo.respository.VuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PasajeroService {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Autowired
    private VuelosRepository vuelosRepository;

    public List<PasajeroResponse> obtenerTodos() {
        return pasajeroRepository.obtenerTodos();
    }

    public Optional<PasajeroResponse> obtenerPorId(int id) {
        return pasajeroRepository.obtenerPorId(id);
    }

    public String crearPasajero(PasajeroRequest req) {
        // Validar que haya asientos disponibles
        int asientosDisponibles = vuelosRepository.obtenerAsientosDisponibles(req.getIdVuelos());
        if (asientosDisponibles <= 0) {
            return "❌ No hay asientos disponibles en ese vuelo";
        }

        pasajeroRepository.crearPasajero(req);
        return "✅ Pasajero creado correctamente";
    }

    public int actualizarPasajero(int id, PasajeroRequest req) {
        return pasajeroRepository.actualizarPasajero(id, req);
    }

    public int eliminarPasajero(int id) {
        return pasajeroRepository.eliminarPasajero(id);
    }
}
