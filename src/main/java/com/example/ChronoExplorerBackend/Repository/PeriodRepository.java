package com.example.ChronoExplorerBackend.Repository;

import com.example.ChronoExplorerBackend.Entity.Period;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeriodRepository extends JpaRepository<Period, Long> {
}
