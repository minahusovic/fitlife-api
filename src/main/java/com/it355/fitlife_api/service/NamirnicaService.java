package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.NamirnicaRequest;
import com.it355.fitlife_api.entity.Namirnica;
import com.it355.fitlife_api.repository.NamirnicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NamirnicaService {

    private final NamirnicaRepository namirnicaRepository;

    public NamirnicaService(NamirnicaRepository namirnicaRepository) {
        this.namirnicaRepository = namirnicaRepository;
    }

    public List<Namirnica> getAll() {
        return namirnicaRepository.findAll();
    }

    public Namirnica getById(Long id) {
        return namirnicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Namirnica nije pronađena."));
    }

    @Transactional
    public Namirnica create(NamirnicaRequest request) {
        Namirnica namirnica = new Namirnica(
                request.getNaziv(),
                request.getKalorijeNa100g(),
                request.getProteiniNa100g(),
                request.getUgljeniHidratiNa100g(),
                request.getMastiNa100g()
        );

        return namirnicaRepository.save(namirnica);
    }

    @Transactional
    public Namirnica update(Long id, NamirnicaRequest request) {
        Namirnica namirnica = getById(id);

        namirnica.setNaziv(request.getNaziv());
        namirnica.setKalorijeNa100g(request.getKalorijeNa100g());
        namirnica.setProteiniNa100g(request.getProteiniNa100g());
        namirnica.setUgljeniHidratiNa100g(request.getUgljeniHidratiNa100g());
        namirnica.setMastiNa100g(request.getMastiNa100g());

        return namirnicaRepository.save(namirnica);
    }

    @Transactional
    public void delete(Long id) {
        Namirnica namirnica = getById(id);
        namirnicaRepository.delete(namirnica);
    }
}