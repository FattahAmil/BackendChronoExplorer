package com.example.ChronoExplorerBackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Relation avec Event
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
