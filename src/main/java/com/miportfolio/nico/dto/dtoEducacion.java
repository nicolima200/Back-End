
package com.miportfolio.nico.dto;

import jakarta.validation.constraints.NotBlank;


public class dtoEducacion {
   @NotBlank
   private String nombreE;
   @NotBlank
   private String descripcionE;
   
   private String url;
   private String path;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String url, String path) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.url=url;
        this.path=path;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
   
   
}
