package com.example.ChronoExplorerBackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean approved; // Pour savoir si le commentaire a été approuvé par un modérateur

    // Relation avec Event
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // Relation avec User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
