package com.example.ChronoExplorerBackend.Repository;

import com.example.ChronoExplorerBackend.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Recherche des commentaires par événement
    List<Comment> findByEventId(Long eventId);

    // Recherche des commentaires par utilisateur
    List<Comment> findByUserId(Long userId);
}
