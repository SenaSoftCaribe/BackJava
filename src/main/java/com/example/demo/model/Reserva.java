package com.example.demo.model;

import java.time.LocalDateTime;

public class Reserva {
    private Integer idReserva;
    private LocalDateTime fechaReserva;
    private Integer pasajeroId;

    public Reserva() {
    }

    public Reserva(Integer idReserva, LocalDateTime fechaReserva, Integer pasajeroId) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.pasajeroId = pasajeroId;
    }

    public Integer getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Integer pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }
}
