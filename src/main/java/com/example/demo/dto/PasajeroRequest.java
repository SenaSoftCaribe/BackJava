package com.example.demo.dto;

public class PasajeroRequest {
    private Integer idVuelos;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String tipoDocumento;
    private Integer numeroDocumento;
    private String condicionInfante;
    private String celular;
    private String correo;
   ;  // para relacionar con vuelos

    // getters y setters


    public PasajeroRequest(Integer idVuelos, String nombre, String primerApellido, String segundoApellido, String tipoDocumento, Integer numeroDocumento, String condicionInfante, String celular, String correo, Integer idVuelo) {
        this.idVuelos = idVuelos;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.condicionInfante = condicionInfante;
        this.celular = celular;
        this.correo = correo;

    }

    public Integer getIdVuelos() {
        return idVuelos;
    }

    public void setIdVuelos(Integer idVuelos) {
        this.idVuelos = idVuelos;
    }

    public PasajeroRequest() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getCondicionInfante() {
        return condicionInfante;
    }

    public void setCondicionInfante(String condicionInfante) {
        this.condicionInfante = condicionInfante;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


}