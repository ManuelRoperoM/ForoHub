package com.alura.forohub.api.entity.topics;

import com.alura.forohub.api.entity.courses.Course;
import com.alura.forohub.api.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DtoCreateTopic(
        @NotNull(message = "El titulo no puede estar vacio")
        String title,
        @NotNull(message = "El post debe tener un mensaje")
        String message,
        @NotNull(message = "El id del user debe estar")
        Long userId,
        @NotNull(message = "El id del curso debe estar")
        Long courseId
) {
}
