package com.alura.forohub.api.service.responses;

import com.alura.forohub.api.service.users.DtoUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;
import java.util.List;

public record DtoResponse(
        @NotBlank
        String message,
        @PastOrPresent
        Date createdAt,
        List<DtoUser> author
) {
}
