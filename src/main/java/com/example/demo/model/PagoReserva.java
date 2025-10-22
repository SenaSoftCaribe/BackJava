package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoReserva {
    private Integer idPagosReserva;
    private String tipoPago;
    private String fecha;
    private Integer reservaId;
    private Integer pagadorId;

    public PagoReserva() {}

    public PagoReserva(Integer idPagosReserva, String tipoPago, String fecha, Integer reservaId, Integer pagadorId) {
        this.idPagosReserva = idPagosReserva;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.pagadorId = pagadorId;
    }

}
