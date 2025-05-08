package com.example.ChronoExplorerBackend.Entity;

import jakarta.persistence.*;

import java.util.List;
import lombok.Data;

@Data
@Entity
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // Relation un-à-plusieurs avec Event
    @OneToMany(mappedBy = "period")
    private List<Event> events;
}
