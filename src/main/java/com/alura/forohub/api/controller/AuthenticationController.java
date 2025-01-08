package com.alura.forohub.api.controller;

import com.alura.forohub.api.entity.users.DtoAuthenticateUser;
import com.alura.forohub.api.entity.users.User;
import com.alura.forohub.api.entity.users.UserRepository;
import com.alura.forohub.api.security.DtoJWTToken;
import com.alura.forohub.api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity authenticationUser(@RequestBody @Valid DtoAuthenticateUser dtoAuthenticateUser) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dtoAuthenticateUser.email(), dtoAuthenticateUser.password());
        System.out.println("Auth token es:" + authToken);
        authenticationManager.authenticate(authToken);
        return ResponseEntity.ok().build();
        /*System.out.println("Hola desde authentiattion controller");
        Authentication authToken = new UsernamePasswordAuthenticationToken(dtoAuthenticateUser.email(), dtoAuthenticateUser.password());
        System.out.println("Email: " + dtoAuthenticateUser.email() + " Password: " + dtoAuthenticateUser.password());
        System.out.println("Auth token: " + authToken);
        var authenticateUser = authenticationManager.authenticate(authToken);
        System.out.println("Authenticate User: " + authenticateUser);
        var JWTtoken = tokenService.generateToken((User) authenticateUser.getPrincipal());
        System.out.println("JWTTOKEN: " + JWTtoken);
        return ResponseEntity.ok(new DtoJWTToken(JWTtoken));*/
    }
}
