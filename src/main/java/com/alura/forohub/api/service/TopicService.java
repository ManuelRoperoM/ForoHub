package com.alura.forohub.api.service;

import com.alura.forohub.api.entity.courses.Course;
import com.alura.forohub.api.entity.courses.CourseRepository;
import com.alura.forohub.api.entity.topics.*;
import com.alura.forohub.api.entity.users.User;
import com.alura.forohub.api.entity.users.UserRepository;
import com.alura.forohub.api.errors.AplicationErros;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository coursesRepository;
    public ResponseEntity<DtoResponseCreateTopic> newTopic(DtoCreateTopic createTopicDto) {
        Optional<Topic> existTopic = topicRepository.findByTitle(createTopicDto.title());
        if (existTopic.isEmpty()){
            Optional<Course> course = coursesRepository.findById(createTopicDto.courseId());
            Optional<User> user = userRepository.findById(createTopicDto.userId());
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            DtoTopic dtoTopic = new DtoTopic(createTopicDto.title(), createTopicDto.message(), timestamp, "Open", user.get(), course.get());
            Topic topic = topicRepository.save(new Topic(dtoTopic));
            DtoResponseCreateTopic newTopic = new DtoResponseCreateTopic(topic.getTitle(),topic.getMessage(),topic.getCreatedAt(),topic.getStatus(),user.get().getName(),course.get().getName());
            return ResponseEntity.ok(newTopic);
        }else {
            throw new AplicationErros("El titulo del topico ya existe");
        }
    }

    public ResponseEntity<List<DtoResponseCreateTopic>> findAll() {
        List<Topic> topics = topicRepository.findAll();

        List<DtoResponseCreateTopic> response = topics.stream()
                .map(topic -> new DtoResponseCreateTopic(
                        topic.getTitle(),
                        topic.getMessage(),
                        topic.getCreatedAt(),
                        topic.getStatus(),
                        topic.getUser().getEmail(),
                        topic.getCourse().getName()
                )).toList();
        return ResponseEntity.ok(response);
    }
}
