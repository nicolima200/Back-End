
package com.miportfolio.nico.Repository;

import com.miportfolio.nico.Entity.Persona;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    public Optional<Persona> findById(int id);
    

    
}
