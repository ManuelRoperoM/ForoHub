package com.alura.forohub.api.service.topics;

import com.alura.forohub.api.service.courses.Course;
import com.alura.forohub.api.service.responses.Response;
import com.alura.forohub.api.service.users.User;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
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
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Response> responses;

    public Topic(String title, String message, Date createdAt, String status) {
        this.title = title;
        this.message = message;
        this.createdAt = createdAt;
        this.status = status;
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
}
