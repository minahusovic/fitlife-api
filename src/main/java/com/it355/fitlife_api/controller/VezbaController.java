package com.it355.fitlife_api.controller;

import com.it355.fitlife_api.dto.VezbaRequest;
import com.it355.fitlife_api.entity.Vezba;
import com.it355.fitlife_api.service.VezbaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vezbe")
@CrossOrigin(origins = "*")
public class VezbaController {

    private final VezbaService vezbaService;

    public VezbaController(VezbaService vezbaService) {
        this.vezbaService = vezbaService;
    }

    @GetMapping
    public ResponseEntity<List<Vezba>> getAll() {
        return ResponseEntity.ok(vezbaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vezba> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vezbaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Vezba> create(@RequestBody VezbaRequest request) {
        return ResponseEntity.ok(vezbaService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vezba> update(@PathVariable Long id,
                                        @RequestBody VezbaRequest request) {
        return ResponseEntity.ok(vezbaService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vezbaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}