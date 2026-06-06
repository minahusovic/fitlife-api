package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.StavkaObrokaRequest;
import com.it355.fitlife_api.entity.Namirnica;
import com.it355.fitlife_api.entity.Obrok;
import com.it355.fitlife_api.entity.StavkaObroka;
import com.it355.fitlife_api.repository.NamirnicaRepository;
import com.it355.fitlife_api.repository.ObrokRepository;
import com.it355.fitlife_api.repository.StavkaObrokaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StavkaObrokaService {

    private final StavkaObrokaRepository stavkaObrokaRepository;
    private final ObrokRepository obrokRepository;
    private final NamirnicaRepository namirnicaRepository;

    public StavkaObrokaService(StavkaObrokaRepository stavkaObrokaRepository,
                               ObrokRepository obrokRepository,
                               NamirnicaRepository namirnicaRepository) {
        this.stavkaObrokaRepository = stavkaObrokaRepository;
        this.obrokRepository = obrokRepository;
        this.namirnicaRepository = namirnicaRepository;
    }

    @Transactional
    public StavkaObroka addToObrok(Long obrokId, StavkaObrokaRequest request) {
        Obrok obrok = obrokRepository.findById(obrokId)
                .orElseThrow(() -> new RuntimeException("Obrok nije pronađen."));

        Namirnica namirnica = namirnicaRepository.findById(request.getNamirnicaId())
                .orElseThrow(() -> new RuntimeException("Namirnica nije pronađena."));

        StavkaObroka stavka = new StavkaObroka(
                request.getKolicinaGrama(),
                obrok,
                namirnica
        );

        return stavkaObrokaRepository.save(stavka);
    }

    @Transactional
    public void delete(Long id) {
        StavkaObroka stavka = stavkaObrokaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stavka obroka nije pronađena."));

        stavkaObrokaRepository.delete(stavka);
    }
}