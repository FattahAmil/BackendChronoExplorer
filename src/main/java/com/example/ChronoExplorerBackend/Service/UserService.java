package com.example.ChronoExplorerBackend.Service;

import com.example.ChronoExplorerBackend.Entity.Role;
import com.example.ChronoExplorerBackend.Entity.User;
import com.example.ChronoExplorerBackend.Repository.RoleRepository;
import com.example.ChronoExplorerBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    // Méthode pour récupérer un utilisateur par son nom d'utilisateur
    public User getUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    // Méthode pour créer un utilisateur
    public User createUser(User user) {
        if (user.getRole() == null) {
            Role defaultRole = roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new RuntimeException("ROLE_USER not found"));
            user.setRole(defaultRole);
        } else {
            // Si un rôle est fourni, on doit s'assurer que c'est un rôle existant
            Role existingRole = roleRepository.findById(user.getRole().getId())
                    .orElseThrow(() -> new RuntimeException("Role not found with id: " + user.getRole().getId()));
            user.setRole(existingRole);
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }
}
