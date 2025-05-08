package com.example.ChronoExplorerBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Period;

public interface PeriodRepository extends JpaRepository<Period, Long> {
}
