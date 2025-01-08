package com.alura.forohub.api.controller;

import com.alura.forohub.api.entity.users.DtoResponseUser;
import com.alura.forohub.api.entity.users.DtoUser;
import com.alura.forohub.api.entity.users.UserRepository;
import com.alura.forohub.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<DtoResponseUser> createUser(@RequestBody @Valid DtoUser registerUserDto,
                                                      UriComponentsBuilder uriComponentsBuilder) {
        return userService.newUser(registerUserDto);
    }
}
