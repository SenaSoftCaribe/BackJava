package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoReserva {
    private Integer idPagosReserva;
    private String tipoPago;
    private LocalDateTime fecha;
    private Integer reservaId;
    private Integer pagadorId;
    private BigDecimal monto;

    public Integer getIdPagosReserva() { return idPagosReserva; }
    public void setIdPagosReserva(Integer idPagosReserva) { this.idPagosReserva = idPagosReserva; }

    public String getTipoPago() { return tipoPago; }
    public void setTipoPago(String tipoPago) { this.tipoPago = tipoPago; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public Integer getReservaId() { return reservaId; }
    public void setReservaId(Integer reservaId) { this.reservaId = reservaId; }

    public Integer getPagadorId() { return pagadorId; }
    public void setPagadorId(Integer pagadorId) { this.pagadorId = pagadorId; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
}
