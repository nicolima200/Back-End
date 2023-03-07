package com.miportfolio.nico.Service;

import com.miportfolio.nico.Entity.Persona;

import com.miportfolio.nico.Repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
    //@Override
    //public List<Persona> getPersona() {
      //  List<Persona> persona = ipersonaRepository.findAll();
        //return persona;
    //}
    public List<Persona> list(){
        return ipersonaRepository.findAll();
    }
    
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona); 
    }

    
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
       }

    
    public Optional<Persona> getOne(int id) {
      return  ipersonaRepository.findById(id);
    }
    
    
    
}
