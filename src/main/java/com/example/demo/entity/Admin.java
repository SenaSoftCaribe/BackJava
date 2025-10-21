package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
    public class Admin {
        @Id
        private Integer idAdmin;

        private String nombreAdmin;
        private String passwordAdmin;
        private String correoito2;
    }

