package com.example.ChronoExplorerBackend.Controller;
import com.example.ChronoExplorerBackend.Service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/api/periods")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @GetMapping
    public List<Period> getAllPeriods() {
        return periodService.getAllPeriods();
    }

    @GetMapping("/{id}")
    public Period getPeriod(@PathVariable Long id) {
        return periodService.getPeriodById(id);
    }

    @PostMapping
    public Period createPeriod(@RequestBody Period period) {
        return periodService.createPeriod(period);
    }

    @DeleteMapping("/{id}")
    public void deletePeriod(@PathVariable Long id) {
        periodService.deletePeriod(id);
    }
}
