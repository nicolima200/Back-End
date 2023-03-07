package com.miportfolio.nico.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String apellido;
    
    @NotNull
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String titulo;
    
    private String acercaDe;

    
    public String url;
    
    public Persona(){}
   
    public Persona(String nombre, String apellido, String titulo, String acercaDe, String url) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.acercaDe = acercaDe;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
