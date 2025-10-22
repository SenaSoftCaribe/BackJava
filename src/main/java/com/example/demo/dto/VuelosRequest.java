package com.example.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class VuelosRequest {

    @NotBlank
    private String origen;
    @NotBlank private String destino;
    @NotNull private LocalDate fechaSalida;
    private LocalTime horaSalida;
    @NotNull @DecimalMin("0.0") private BigDecimal precio;
    @NotNull
    private Integer avionId;

    // getters/setters
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }
    public LocalTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalTime horaSalida) { this.horaSalida = horaSalida; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public Integer getAvionId() { return avionId; }
    public void setAvionId(Integer avionId) { this.avionId = avionId; }


}
