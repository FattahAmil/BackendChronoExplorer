package com.example.ChronoExplorerBackend.Repository;

import com.example.ChronoExplorerBackend.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Recherche un rôle par son nom
    Optional<Role> findByName(String name);
}
