
package com.miportfolio.nico.Security.Dto;

import java.util.HashSet;
import java.util.Set;


public class NuevoUsuario {
    private String nombre;
    private String usuario;
    private String nombreUsuario;
    private String password;
    private String email;
    private Set<String> roles= new HashSet<>();
    
    public String getNombre() {
        return nombre;
    }

    //getter & setter
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
}
