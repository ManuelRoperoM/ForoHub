package com.alura.forohub.api.entity.topics;

import com.alura.forohub.api.entity.courses.Course;
import com.alura.forohub.api.entity.responses.Response;
import com.alura.forohub.api.entity.users.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public record DtoTopic(
        String title,
        String message,
        Date createdAt,
        String status,
        User user,
        Course course
) {
}
