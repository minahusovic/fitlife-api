package com.it355.fitlife_api.controller;

import com.it355.fitlife_api.dto.StatistikaResponse;
import com.it355.fitlife_api.service.StatistikaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/statistika")
@CrossOrigin(origins = "*")
public class StatistikaController {

    private final StatistikaService statistikaService;

    public StatistikaController(StatistikaService statistikaService) {
        this.statistikaService = statistikaService;
    }

    @GetMapping("/dnevna")
    public ResponseEntity<StatistikaResponse> getDnevnaStatistika(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datum
    ) {
        return ResponseEntity.ok(statistikaService.getDnevnaStatistika(userId, datum));
    }
}