package com.alura.forohub.api.entity.responses;

import com.alura.forohub.api.entity.topics.Topic;
import com.alura.forohub.api.entity.users.User;
import jakarta.persistence.*;

import java.util.Date;

@Table(name = "responses")
@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @ManyToOne()
    private User user;
    @ManyToOne()
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Response(String message, Date createdAt, User user) {
        this.message = message;
        this.createdAt = createdAt;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
