package com.example.ChronoExplorerBackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;  // Exemple: "image", "video", "text"
    private String url;   // URL du média (peut être un chemin local ou un lien externe)

    // Relation avec Event
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
