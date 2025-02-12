package com.alura.forohub.api.entity.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoUser(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
) {
}
