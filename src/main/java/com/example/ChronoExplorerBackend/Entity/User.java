package com.example.ChronoExplorerBackend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;// ROLE_USER, ROLE_MODERATOR, etc.

    // Relation plusieurs-à-plusieurs avec Event pour les favoris
    @ManyToMany
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> favorites;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}

    public List<Event> getFavorites() { return favorites; }
    public void setFavorites(List<Event> favorites) { this.favorites = favorites; }
}
