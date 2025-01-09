package com.alura.forohub.api.entity.topics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findByTitle(String title);
    @Modifying
    @Query("DELETE FROM Topic t WHERE t.id = :id")
    void deleteById(@Param("id") Long id);
}
