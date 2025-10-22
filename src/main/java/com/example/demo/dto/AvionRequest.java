package com.example.demo.dto;

import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.*;



public class AvionRequest {
    @NotBlank
    private String modelo;
    private String marca;
    @NotNull
    @Min(1)
    private Integer asientos;
    private String estado;




    // Getter y Setter para modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Getter y Setter para marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter y Setter para asientos
    public Integer getAsientos() {
        return asientos;
    }

    public void setAsientos(Integer asientos) {
        this.asientos = asientos;
    }

    // Getter y Setter para estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
