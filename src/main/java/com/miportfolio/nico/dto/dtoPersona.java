
package com.miportfolio.nico.dto;


public class dtoPersona {
    private String nombre;
    private String apellido;
    private String titulo;
    private String acercaDe;
    private String url;
    
    public dtoPersona(String nombre, String apellido, String titulo, String acercaDe, String url){
        this.nombre=nombre; 
        this.apellido=apellido;
        this.titulo=titulo; 
        this.acercaDe=acercaDe;
        this.url=url;
    
    
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
