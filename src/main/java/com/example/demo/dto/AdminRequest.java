

package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class AdminRequest {
    @NotBlank
    private String nombreAdmin;

    @NotBlank
    @Size(min = 8)
    private String password; // plaintext incoming; debes hashear en servicio

    @NotBlank
    @Email
    private String correo;

    // getters / setters
    public String getNombreAdmin() { return nombreAdmin; }
    public void setNombreAdmin(String nombreAdmin) { this.nombreAdmin = nombreAdmin; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
