package com.example.demo.model;

public class Pagos {

        private Integer idPago;
        private String tipoPago;
        private String fecha;
        private Integer pagadorId;
        private Integer pasajeroId;

        // Constructor vacío
        public Pagos() {
        }

        // Constructor completo
        public Pagos(Integer idPago, String tipoPago, String fecha, Integer pagadorId, Integer pasajeroId) {
            this.idPago = idPago;
            this.tipoPago = tipoPago;
            this.fecha = fecha;
            this.pagadorId = pagadorId;
            this.pasajeroId = pasajeroId;
        }

        // Getters y Setters

        public Integer getIdPago() {
            return idPago;
        }

        public void setIdPago(Integer idPago) {
            this.idPago = idPago;
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


