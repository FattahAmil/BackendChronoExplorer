package com.example.ChronoExplorerBackend.Service;

import com.example.ChronoExplorerBackend.Entity.Comment;
import com.example.ChronoExplorerBackend.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Méthode pour récupérer les commentaires par événement
    public List<Comment> getCommentsByEvent(Long eventId) {
        return commentRepository.findByEventId(eventId);
    }

    // Méthode pour créer un commentaire
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Méthode pour supprimer un commentaire
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
