package com.example.demo.dto;

public class PagadorResponse {
    private Integer idPagador;
    private String nombre;
    private String tipoDocumento;
    private String correo;
    private String telefono;

    public PagadorResponse() {
    }

    public PagadorResponse(Integer idPagador, String nombre, String tipoDocumento, String correo, String telefono) {
        this.idPagador = idPagador;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdPagador() {
        return idPagador;
    }

    public void setIdPagador(Integer idPagador) {
        this.idPagador = idPagador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
