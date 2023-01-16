package com.miportfolio.nico.Security.Repository;

import com.miportfolio.nico.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    //devuelve verdadero si existe nombre de usuario y email
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
}
