package com.example.ChronoExplorerBackend.Service;

import com.example.ChronoExplorerBackend.Entity.Period;
import com.example.ChronoExplorerBackend.Repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    // Méthode pour récupérer toutes les périodes
    public List<Period> getAllPeriods() {
        return periodRepository.findAll();
    }

    // Méthode pour récupérer une période par son ID
    public Period getPeriodById(Long id) {
        return periodRepository.findById(id).orElse(null);
    }

    // Méthode pour créer une période
    public Period createPeriod(Period period) {
        return periodRepository.save(period);
    }

    // Méthode pour supprimer une période
    public void deletePeriod(Long id) {
        periodRepository.deleteById(id);
    }
}
