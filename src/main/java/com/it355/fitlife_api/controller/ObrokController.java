package com.it355.fitlife_api.controller;

import com.it355.fitlife_api.dto.ObrokRequest;
import com.it355.fitlife_api.entity.Obrok;
import com.it355.fitlife_api.service.ObrokService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obroci")
@CrossOrigin(origins = "*")
public class ObrokController {

    private final ObrokService obrokService;

    public ObrokController(ObrokService obrokService) {
        this.obrokService = obrokService;
    }

    @GetMapping
    public ResponseEntity<List<Obrok>> getAll() {
        return ResponseEntity.ok(obrokService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obrok> getById(@PathVariable Long id) {
        return ResponseEntity.ok(obrokService.getById(id));
    }

    @GetMapping("/korisnik/{userId}")
    public ResponseEntity<List<Obrok>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(obrokService.getByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Obrok> create(@RequestBody ObrokRequest request) {
        return ResponseEntity.ok(obrokService.create(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        obrokService.delete(id);
        return ResponseEntity.noContent().build();
    }
}