package com.example.ChronoExplorerBackend.Service;

import com.example.ChronoExplorerBackend.Entity.Favorite;
import com.example.ChronoExplorerBackend.Repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    // Méthode pour récupérer les favoris d'un utilisateur
    public List<Favorite> getFavoritesByUser(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    // Méthode pour ajouter un événement aux favoris
    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    // Méthode pour supprimer un événement des favoris
    public void removeFavorite(Long userId, Long eventId) {
        favoriteRepository.deleteByUserIdAndEventId(userId, eventId);
    }
}
