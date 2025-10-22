package com.example.demo.service;

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

        public List<Vuelos> obtenerTodos() {
            return repository.findAll();
        }

        public Vuelos obtenerPorId(int id) {
            return repository.findById(id);
        }

        public Vuelos crearVuelo(Vuelos vuelo) {
            return repository.save(vuelo);
        }

        public Vuelos actualizarVuelo(Vuelos vuelo) {
            repository.update(vuelo);
            return vuelo;
        }

        public void eliminarVuelo(int id) {
            repository.delete(id);
        }
}
