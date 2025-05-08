package com.example.ChronoExplorerBackend.Entity;

import jakarta.persistence.*;

import java.util.*;
import lombok.Data;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date eventDate;

    // Relation avec Period
    @ManyToOne
    @JoinColumn(name = "period_id", nullable = false)
    private Period period;

    // Relation un-à-plusieurs avec Media
    @OneToMany(mappedBy = "event")
    private List<Media> media;

    // Relation un-à-plusieurs avec Comment
    @OneToMany(mappedBy = "event")
    private List<Comment> comments;

}
