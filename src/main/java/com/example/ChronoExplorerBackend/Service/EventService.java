package com.example.ChronoExplorerBackend.Service;

import com.example.ChronoExplorerBackend.Entity.Event;
import com.example.ChronoExplorerBackend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Méthode pour récupérer tous les événements
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Méthode pour récupérer un événement par ID
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    // Méthode pour créer un événement
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Méthode pour supprimer un événement
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    // Méthode pour récupérer des événements par période
    public List<Event> getEventsByPeriod(Long periodId) {
        return eventRepository.findByPeriodId(periodId);
    }
}
