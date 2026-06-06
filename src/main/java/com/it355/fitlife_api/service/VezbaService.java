package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.VezbaRequest;
import com.it355.fitlife_api.entity.Vezba;
import com.it355.fitlife_api.repository.VezbaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VezbaService {

    private final VezbaRepository vezbaRepository;

    public VezbaService(VezbaRepository vezbaRepository) {
        this.vezbaRepository = vezbaRepository;
    }

    public List<Vezba> getAll() {
        return vezbaRepository.findAll();
    }

    public Vezba getById(Long id) {
        return vezbaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vežba nije pronađena."));
    }

    @Transactional
    public Vezba create(VezbaRequest request) {
        Vezba vezba = new Vezba(
                request.getNaziv(),
                request.getMisicnaGrupa(),
                request.getOpis(),
                request.getKalorijePoMinutu()
        );

        return vezbaRepository.save(vezba);
    }

    @Transactional
    public Vezba update(Long id, VezbaRequest request) {
        Vezba vezba = getById(id);

        vezba.setNaziv(request.getNaziv());
        vezba.setMisicnaGrupa(request.getMisicnaGrupa());
        vezba.setOpis(request.getOpis());
        vezba.setKalorijePoMinutu(request.getKalorijePoMinutu());

        return vezbaRepository.save(vezba);
    }

    @Transactional
    public void delete(Long id) {
        Vezba vezba = getById(id);
        vezbaRepository.delete(vezba);
    }
}