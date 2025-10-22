package com.example.demo.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Vuelos {
    private int idVuelos;
    private String origen;
    private String destino;
    private LocalDate fechaSalida;
    private LocalTime hora;
    private BigDecimal precio;
    private int avion;

    // Constructor vacío (necesario)
    public Vuelos() {}

    // Getters y Setters

    public int getIdVuelos() {
        return idVuelos;
    }

    public void setIdVuelos(int idVuelos) {
        this.idVuelos = idVuelos;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getAvion() {
        return avion;
    }

    public void setAvion(int avion) {
        this.avion = avion;
    }
}
