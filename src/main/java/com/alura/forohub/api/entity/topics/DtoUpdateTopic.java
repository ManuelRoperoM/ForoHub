package com.alura.forohub.api.entity.topics;

import jakarta.validation.constraints.NotNull;

public record DtoUpdateTopic(
        String title,
        String message,
        String status
) {
}
