package com.it355.fitlife_api.controller;

import com.it355.fitlife_api.dto.TreningRequest;
import com.it355.fitlife_api.entity.Trening;
import com.it355.fitlife_api.service.TreningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treninzi")
@CrossOrigin(origins = "*")
public class TreningController {

    private final TreningService treningService;

    public TreningController(TreningService treningService) {
        this.treningService = treningService;
    }

    @GetMapping
    public ResponseEntity<List<Trening>> getAll() {
        return ResponseEntity.ok(treningService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trening> getById(@PathVariable Long id) {
        return ResponseEntity.ok(treningService.getById(id));
    }

    @GetMapping("/korisnik/{userId}")
    public ResponseEntity<List<Trening>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(treningService.getByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Trening> create(@RequestBody TreningRequest request) {
        return ResponseEntity.ok(treningService.create(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        treningService.delete(id);
        return ResponseEntity.noContent().build();
    }
}