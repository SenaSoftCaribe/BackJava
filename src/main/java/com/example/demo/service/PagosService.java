package com.example.demo.service;

import com.example.demo.dto.PagoRequest;
import com.example.demo.dto.PagoResponse;
import com.example.demo.respository.PagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosService {

    private final PagosRepository pagoDAO;

    public PagosService(PagosRepository pagoDAO) {
        this.pagoDAO = pagoDAO;
    }

        public List<PagoResponse> getAll() {
            return pagoDAO.findAll();
        }

        public PagoResponse getById(int id) {
            return pagoDAO.findById(id);
        }

        public void create(PagoRequest request) {
            pagoDAO.save(request);
        }

        public void update(PagoRequest request) {
            pagoDAO.update(request);
        }

        public void delete(int id) {
            pagoDAO.delete(id);
        }
    }

