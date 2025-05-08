package com.example.ChronoExplorerBackend.Controller;

import com.example.ChronoExplorerBackend.Entity.Media;
import com.example.ChronoExplorerBackend.Service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    // Récupérer les médias par événement
    @GetMapping("/event/{eventId}")
    public List<Media> getMediaByEvent(@PathVariable Long eventId) {
        return mediaService.getMediaByEvent(eventId);
    }

    // Créer un média
    @PostMapping
    public Media createMedia(@RequestBody Media media) {
        return mediaService.createMedia(media);
    }

    // Supprimer un média
    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
    }
}
