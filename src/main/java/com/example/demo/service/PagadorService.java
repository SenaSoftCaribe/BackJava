package com.example.demo.service;

import com.example.demo.dto.PagadorRequest;
import com.example.demo.dto.PagadorResponse;
import com.example.demo.respository.PagadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class PagadorService {

        private final PagadorRepository pagadorDAO;

        public PagadorService(PagadorRepository pagadorDAO) {
            this.pagadorDAO = pagadorDAO;
        }

        public List<PagadorResponse> getAll() {
            return pagadorDAO.findAll();
        }

        public PagadorResponse getById(int id) {
            return pagadorDAO.findById(id);
        }

        public void create(PagadorRequest request) {
            pagadorDAO.save(request);
        }

        public void update(PagadorRequest request) {
            pagadorDAO.update(request);
        }

        public void delete(int id) {
            pagadorDAO.delete(id);
        }
    }

