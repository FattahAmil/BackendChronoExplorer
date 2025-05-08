package com.example.ChronoExplorerBackend.Repository;

import com.example.ChronoExplorerBackend.Entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    // Recherche des favoris par utilisateur
    List<Favorite> findByUserId(Long userId);

    // Recherche des favoris par événement
    List<Favorite> findByEventId(Long eventId);

    void deleteByUserIdAndEventId(Long userId, Long eventId);
}
