package com.alura.forohub.api.security;

import com.alura.forohub.api.entity.users.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authHeader = request.getHeader("Authorization");
        System.out.println("HOla desde el do FIlter");
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("AuthHeader: " + authHeader);
        if(authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var userEmail = tokenService.getSubject(token);
            System.out.println("EL user Email es: " + userEmail);
            if (userEmail != null) {
                //Token valido
                System.out.println("Entre en el IF");
                var user = userRepository.findByEmail(userEmail);
                var authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities()); // Forzamos un inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
