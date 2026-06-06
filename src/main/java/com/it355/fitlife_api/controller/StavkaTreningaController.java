package com.it355.fitlife_api.controller;

import com.it355.fitlife_api.dto.StavkaTreningaRequest;
import com.it355.fitlife_api.entity.StavkaTreninga;
import com.it355.fitlife_api.service.StavkaTreningaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StavkaTreningaController {

    private final StavkaTreningaService stavkaTreningaService;

    public StavkaTreningaController(StavkaTreningaService stavkaTreningaService) {
        this.stavkaTreningaService = stavkaTreningaService;
    }

    @PostMapping("/api/treninzi/{treningId}/stavke")
    public ResponseEntity<StavkaTreninga> addToTrening(@PathVariable Long treningId,
                                                       @RequestBody StavkaTreningaRequest request) {
        return ResponseEntity.ok(stavkaTreningaService.addToTrening(treningId, request));
    }

    @DeleteMapping("/api/stavke-treninga/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stavkaTreningaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}