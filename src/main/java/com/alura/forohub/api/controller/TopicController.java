package com.alura.forohub.api.controller;

import com.alura.forohub.api.entity.topics.*;
import com.alura.forohub.api.entity.users.DtoResponseUser;
import com.alura.forohub.api.entity.users.DtoUser;
import com.alura.forohub.api.service.TopicService;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicController {
    @Autowired
    TopicService topicService;
    @Autowired
    TopicRepository topicRepository;
    @PostMapping
    public ResponseEntity<DtoResponseCreateTopic> createTopic(@RequestBody @Valid DtoCreateTopic createTopicDto) {
        return topicService.newTopic(createTopicDto);
    }

    @GetMapping
    public ResponseEntity<List<DtoResponseCreateTopic>> findAllTopics(){
        return topicService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoResponseCreateTopic> findTopicById(@PathVariable Long id){
        Topic topic = topicRepository.findById(id).get();
        DtoResponseCreateTopic response = new DtoResponseCreateTopic(topic.getTitle(),topic.getMessage(),topic.getCreatedAt(),topic.getStatus(),topic.getUser().getEmail(),topic.getCourse().getName());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoResponseCreateTopic> updateTopicById(@PathVariable Long id, @RequestBody @Valid DtoUpdateTopic dtoUpdateTopic) {
        Topic topic = topicRepository.getReferenceById(id);
        topic.updateData(dtoUpdateTopic);
        return ResponseEntity.ok(new DtoResponseCreateTopic(topic.getTitle(),topic.getMessage(),topic.getCreatedAt(),topic.getStatus(),topic.getUser().getEmail(),topic.getCourse().getName()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoDeleteTopic> deleteTopic(@PathVariable Long id) {
        topicRepository.deleteById(id);
        DtoDeleteTopic deleteTopic = new DtoDeleteTopic( "Topico eliminado");
        return ResponseEntity.ok(deleteTopic);
    }

}
