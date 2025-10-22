package com.example.demo.dto;

public class PagadorRequest {
    private Integer idPagador;
    private String nombre;
    private String tipoDocumento;
    private String correo;
    private String telefono;

    public Integer getIdPagador() {
        return idPagador;
    }

    public void setIdPagador(Integer idPagador) {
        this.idPagador = idPagador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
