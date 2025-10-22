package com.example.demo.dto;

public class PagoRequest {
    private Integer idPago;
    private String tipoPago;
    private String fecha;
    private Integer pagadorId;
    private Integer pasajeroId;


    public PagoRequest() {
    }

    public PagoRequest(String tipoPago, Integer idPago, String fecha, Integer pagadorId, Integer pasajeroId) {
        this.tipoPago = tipoPago;
        this.idPago = idPago;
        this.fecha = fecha;
        this.pagadorId = pagadorId;
        this.pasajeroId = pasajeroId;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Integer getPagadorId() {
        return pagadorId;
    }

    public void setPagadorId(Integer pagadorId) {
        this.pagadorId = pagadorId;
    }

    public Integer getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Integer pasajeroId) {
        this.pasajeroId = pasajeroId;
    }
}
