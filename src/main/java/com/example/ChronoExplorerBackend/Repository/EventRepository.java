package com.example.ChronoExplorerBackend.Repository;

import com.example.ChronoExplorerBackend.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    // Méthode pour trouver un événement par son nom (par exemple)
    List<Event> findByName(String name);

    // Méthode pour trouver des événements par leur période
    List<Event> findByPeriodId(Long periodId);
}
