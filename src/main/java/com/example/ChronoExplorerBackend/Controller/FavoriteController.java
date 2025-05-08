package com.example.ChronoExplorerBackend.Controller;

import com.example.ChronoExplorerBackend.Entity.Favorite;
import com.example.ChronoExplorerBackend.Service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // Récupérer les favoris d'un utilisateur
    @GetMapping("/user/{userId}")
    public List<Favorite> getFavoritesByUser(@PathVariable Long userId) {
        return favoriteService.getFavoritesByUser(userId);
    }

    // Ajouter un événement aux favoris
    @PostMapping
    public Favorite addFavorite(@RequestBody Favorite favorite) {
        return favoriteService.addFavorite(favorite);
    }

    // Supprimer un événement des favoris
    @DeleteMapping("/user/{userId}/event/{eventId}")
    public void removeFavorite(@PathVariable Long userId, @PathVariable Long eventId) {
        favoriteService.removeFavorite(userId, eventId);
    }
}
