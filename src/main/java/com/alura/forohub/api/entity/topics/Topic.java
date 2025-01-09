package com.alura.forohub.api.entity.topics;

import com.alura.forohub.api.entity.courses.Course;
import com.alura.forohub.api.entity.responses.Response;
import com.alura.forohub.api.entity.users.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name = "topics")
@Entity()
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String status;
    @ManyToOne()
    private User user;
    @ManyToOne()
    private Course course;
    public Topic() { }

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Response> responses;

    public Topic(String title, String message, Date createdAt, String status) {
        this.title = title;
        this.message = message;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Topic(DtoTopic dtoTopic) {
        this.title = dtoTopic.title();
        this.message = dtoTopic.message();
        this.createdAt = dtoTopic.createdAt();
        this.status = dtoTopic.status();
        this.user = dtoTopic.user();
        this.course = dtoTopic.course();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public void updateData(DtoUpdateTopic dtoUpdateTopic) {
        if (dtoUpdateTopic.message() != null) {
            this.message = dtoUpdateTopic.message();
        }
        if (dtoUpdateTopic.title() != null) {
            this.title = dtoUpdateTopic.title();
        }
        if (dtoUpdateTopic.status() != null) {
            this.status = dtoUpdateTopic.status();
        }
    }
}
