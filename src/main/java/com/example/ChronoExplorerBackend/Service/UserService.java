package com.example.ChronoExplorerBackend.Service;

import com.example.ChronoExplorerBackend.Entity.User;
import com.example.ChronoExplorerBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Méthode pour récupérer un utilisateur par son nom d'utilisateur
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Méthode pour créer un utilisateur
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
