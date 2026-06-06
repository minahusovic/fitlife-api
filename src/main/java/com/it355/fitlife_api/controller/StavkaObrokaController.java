package com.it355.fitlife_api.controller;

import com.it355.fitlife_api.dto.StavkaObrokaRequest;
import com.it355.fitlife_api.entity.StavkaObroka;
import com.it355.fitlife_api.service.StavkaObrokaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StavkaObrokaController {

    private final StavkaObrokaService stavkaObrokaService;

    public StavkaObrokaController(StavkaObrokaService stavkaObrokaService) {
        this.stavkaObrokaService = stavkaObrokaService;
    }

    @PostMapping("/api/obroci/{obrokId}/stavke")
    public ResponseEntity<StavkaObroka> addToObrok(@PathVariable Long obrokId,
                                                   @RequestBody StavkaObrokaRequest request) {
        return ResponseEntity.ok(stavkaObrokaService.addToObrok(obrokId, request));
    }

    @DeleteMapping("/api/stavke-obroka/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stavkaObrokaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}