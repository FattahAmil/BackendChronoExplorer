package com.example.ChronoExplorerBackend.Repository;

import com.example.ChronoExplorerBackend.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    // Recherche des médias par événement
    List<Media> findByEventId(Long eventId);
}
