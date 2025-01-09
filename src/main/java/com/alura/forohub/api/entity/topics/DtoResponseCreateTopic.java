package com.alura.forohub.api.entity.topics;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DtoResponseCreateTopic(
        @NotNull()
        String title,
        @NotNull
        String message,
        @Temporal(TemporalType.TIMESTAMP)
        Date createdAt,
        @NotNull
        String status,
        @NotNull
        String author,
        @NotNull
        String course
) {
}
