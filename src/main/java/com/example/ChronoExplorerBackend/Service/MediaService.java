package com.example.ChronoExplorerBackend.Service;

import com.example.ChronoExplorerBackend.Entity.Media;
import com.example.ChronoExplorerBackend.Repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    // Méthode pour récupérer les médias par événement
    public List<Media> getMediaByEvent(Long eventId) {
        return mediaRepository.findByEventId(eventId);
    }

    // Méthode pour créer un média
    public Media createMedia(Media media) {
        return mediaRepository.save(media);
    }

    // Méthode pour supprimer un média
    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }
}
