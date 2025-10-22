package com.example.demo.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class PagoReservaRequest {
    private String tipoPago;
    private Integer reservaId;
    private Integer pagadorId;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal monto;

    // getters / setters
    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }
    public Integer getReservaId() { return reservaId; }
    public void setReservaId(Integer reservaId) { this.reservaId = reservaId; }
    public Integer getPagadorId() { return pagadorId; }
    public void setPagadorId(Integer pagadorId) { this.pagadorId = pagadorId; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
}
