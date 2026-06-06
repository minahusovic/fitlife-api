package com.it355.fitlife_api.controller;

import com.it355.fitlife_api.dto.NamirnicaRequest;
import com.it355.fitlife_api.entity.Namirnica;
import com.it355.fitlife_api.service.NamirnicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/namirnice")
@CrossOrigin(origins = "*")
public class NamirnicaController {

    private final NamirnicaService namirnicaService;

    public NamirnicaController(NamirnicaService namirnicaService) {
        this.namirnicaService = namirnicaService;
    }

    @GetMapping
    public ResponseEntity<List<Namirnica>> getAll() {
        return ResponseEntity.ok(namirnicaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Namirnica> getById(@PathVariable Long id) {
        return ResponseEntity.ok(namirnicaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Namirnica> create(@RequestBody NamirnicaRequest request) {
        return ResponseEntity.ok(namirnicaService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Namirnica> update(@PathVariable Long id,
                                            @RequestBody NamirnicaRequest request) {
        return ResponseEntity.ok(namirnicaService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        namirnicaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}