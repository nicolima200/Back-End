//Usa la clase del provider para validar el token de nuevo y se ejecuta cada vez que hacemos algo,
//por ejemplo si hacemos alguna modificación, para validar el token, si no es válido, nos pedirá logearnos
package com.miportfolio.nico.Security.jwt;

import com.miportfolio.nico.Security.Service.UserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtTokenFilter extends OncePerRequestFilter {
    private final static Logger logger=LoggerFactory.getLogger(JwtProvider.class);
    
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserDetailsImpl userDetailsServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token= getToken(request);
            if (token != null && jwtProvider.validateToken(token)){
                String nombreUsuario=jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails= userDetailsServiceImpl.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth= new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (Exception e){
                    logger.error("Falló el método doFilterInternal");
         }
        filterChain.doFilter(request, response);
    }
    
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header!=null && header.startsWith("Bearer"))
            return header.replace("Bearer","");
        return null;
    }
}
