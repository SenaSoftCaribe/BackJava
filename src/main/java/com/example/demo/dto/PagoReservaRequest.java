package com.example.demo.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class PagoReservaRequest {
    private Integer idPagosReserva;
    private String tipoPago;
    private String fecha;
    private Integer reservaId;
    private Integer pagadorId;

    public PagoReservaRequest() {
    }

    public PagoReservaRequest(Integer idPagosReserva, String tipoPago, String fecha, Integer reservaId, Integer pagadorId) {
        this.idPagosReserva = idPagosReserva;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.pagadorId = pagadorId;
    }

    public Integer getIdPagosReserva() {
        return idPagosReserva;
    }

    public void setIdPagosReserva(Integer idPagosReserva) {
        this.idPagosReserva = idPagosReserva;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public Integer getPagadorId() {
        return pagadorId;
    }

    public void setPagadorId(Integer pagadorId) {
        this.pagadorId = pagadorId;
    }
}
