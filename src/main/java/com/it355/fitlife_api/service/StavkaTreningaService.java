package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.StavkaTreningaRequest;
import com.it355.fitlife_api.entity.StavkaTreninga;
import com.it355.fitlife_api.entity.Trening;
import com.it355.fitlife_api.entity.Vezba;
import com.it355.fitlife_api.repository.StavkaTreningaRepository;
import com.it355.fitlife_api.repository.TreningRepository;
import com.it355.fitlife_api.repository.VezbaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StavkaTreningaService {

    private final StavkaTreningaRepository stavkaTreningaRepository;
    private final TreningRepository treningRepository;
    private final VezbaRepository vezbaRepository;

    public StavkaTreningaService(StavkaTreningaRepository stavkaTreningaRepository,
                                 TreningRepository treningRepository,
                                 VezbaRepository vezbaRepository) {
        this.stavkaTreningaRepository = stavkaTreningaRepository;
        this.treningRepository = treningRepository;
        this.vezbaRepository = vezbaRepository;
    }

    @Transactional
    public StavkaTreninga addToTrening(Long treningId, StavkaTreningaRequest request) {
        Trening trening = treningRepository.findById(treningId)
                .orElseThrow(() -> new RuntimeException("Trening nije pronađen."));

        Vezba vezba = vezbaRepository.findById(request.getVezbaId())
                .orElseThrow(() -> new RuntimeException("Vežba nije pronađena."));

        StavkaTreninga stavka = new StavkaTreninga(
                request.getBrojSerija(),
                request.getBrojPonavljanja(),
                request.getTezinaKg(),
                request.getTrajanjeMinuta(),
                trening,
                vezba
        );

        return stavkaTreningaRepository.save(stavka);
    }

    @Transactional
    public void delete(Long id) {
        StavkaTreninga stavka = stavkaTreningaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stavka treninga nije pronađena."));

        stavkaTreningaRepository.delete(stavka);
    }
}