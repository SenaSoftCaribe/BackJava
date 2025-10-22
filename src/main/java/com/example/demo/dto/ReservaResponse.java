package com.example.demo.dto;

public class ReservaResponse {

    private Integer idReserva;
    private String fechaReserva;
    private Integer pasajeroId;

    public Integer getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Integer pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public ReservaResponse(Integer idReserva, String fechaReserva, Integer pasajeroId) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.pasajeroId = pasajeroId;




    }
}