package com.miportfolio.nico.Controller;

import com.miportfolio.nico.Entity.Persona;

import com.miportfolio.nico.Service.ImpPersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins={"http://localhost:4200","https://nicoportfolioweb.web.app"})
//@CrossOrigin(origins = "https://nicoportfolioweb.web.app/")
public class PersonaController {
    @Autowired ImpPersonaService impPersonaService;
    
    //Cuando en la url se lea personas/traer, el frontend ejecuta el método
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/traer")
    public ResponseEntity<List<Persona>> list(){
        List<Persona>list= impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    } 
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        impPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        impPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //Para editar un registro
    //Ejemplo de URL:puerto/personas/editar/4?nombre=Pepe&apellido=Santoro&img=otraImg
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable int id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("url") String nuevoUrl){
        Persona persona = impPersonaService.getOne(id).orElse(null);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setUrl(nuevoUrl);
        
        impPersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/traer/perfil/{id}")
    public Optional<Persona> getOne(@PathVariable int id){
        return impPersonaService.getOne((int)(id));
    }
}
