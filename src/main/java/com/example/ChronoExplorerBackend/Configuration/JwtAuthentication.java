package com.example.ChronoExplorerBackend.Configuration;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthentication extends AbstractAuthenticationToken {
    private final String username;

    public JwtAuthentication(String username) {
        super(null);  // Aucun rôle n'est défini ici pour l'instant
        this.username = username;
        setAuthenticated(true);  // L'utilisateur est authentifié après avoir validé le token
    }

    @Override
    public Object getCredentials() {
        return null;  // Le JWT est utilisé pour l'authentification
    }

    @Override
    public Object getPrincipal() {
        return this.username;  // Retourne le nom d'utilisateur
    }
}
