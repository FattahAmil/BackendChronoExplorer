package com.example.ChronoExplorerBackend.Entity;

import jakarta.persistence.*;

import java.util.List;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role; // ROLE_USER, ROLE_MODERATOR, etc.

    // Relation plusieurs-à-plusieurs avec Event pour les favoris
    @ManyToMany
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> favorites;
}
