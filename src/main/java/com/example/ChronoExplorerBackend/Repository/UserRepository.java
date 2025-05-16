package com.example.ChronoExplorerBackend.Repository;

import com.example.ChronoExplorerBackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    // Recherche un utilisateur par son nom d'utilisateur
    User findByEmail(String email);

}
