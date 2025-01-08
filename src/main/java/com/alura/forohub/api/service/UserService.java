package com.alura.forohub.api.service;

import com.alura.forohub.api.entity.users.DtoResponseUser;
import com.alura.forohub.api.entity.users.DtoUser;
import com.alura.forohub.api.entity.users.User;
import com.alura.forohub.api.entity.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseEntity<DtoResponseUser> newUser(DtoUser registerUserDto) {
        String hashedPassword = passwordEncoder.encode(registerUserDto.password());
        DtoUser dtoUser = new DtoUser(registerUserDto.name(), registerUserDto.email(), hashedPassword);
        User user = userRepository.save(new User(dtoUser));
        DtoResponseUser dtoResponseUser = new DtoResponseUser(user.getEmail(), user.getName());
        return ResponseEntity.ok(dtoResponseUser);
    }
}
