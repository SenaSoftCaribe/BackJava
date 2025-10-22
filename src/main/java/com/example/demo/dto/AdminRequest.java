

package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class AdminRequest {

    private int idAdmin;
    private String nombreAdmin;
    private String passwordAdmin;
    private String correo;

    public AdminRequest() {
    }

    public AdminRequest(int idAdmin, String nombreAdmin, String passwordAdmin, String correo) {
        this.idAdmin = idAdmin;
        this.nombreAdmin = nombreAdmin;
        this.passwordAdmin = passwordAdmin;
        this.correo = correo;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
