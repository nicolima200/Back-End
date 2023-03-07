package com.miportfolio.nico.Interface;

import com.miportfolio.nico.Entity.Persona;
import java.util.List;

public interface IPersonaService {
   
    public List<Persona> list();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar una persona por ID
    public Persona findPersona(Long id);
    
    
}
