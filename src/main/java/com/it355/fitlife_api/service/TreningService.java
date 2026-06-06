package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.TreningRequest;
import com.it355.fitlife_api.entity.Trening;
import com.it355.fitlife_api.entity.User;
import com.it355.fitlife_api.repository.TreningRepository;
import com.it355.fitlife_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TreningService {

    private final TreningRepository treningRepository;
    private final UserRepository userRepository;

    public TreningService(TreningRepository treningRepository, UserRepository userRepository) {
        this.treningRepository = treningRepository;
        this.userRepository = userRepository;
    }

    public List<Trening> getAll() {
        return treningRepository.findAll();
    }

    public Trening getById(Long id) {
        return treningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trening nije pronađen."));
    }

    public List<Trening> getByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Korisnik nije pronađen."));

        return treningRepository.findByUser(user);
    }

    @Transactional
    public Trening create(TreningRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Korisnik nije pronađen."));

        Trening trening = new Trening(
                request.getNaziv(),
                request.getDatum(),
                request.getTipTreninga(),
                request.getTrajanjeMinuta(),
                request.getPotroseneKalorije(),
                request.getNapomena(),
                user
        );

        return treningRepository.save(trening);
    }

    @Transactional
    public void delete(Long id) {
        Trening trening = getById(id);
        treningRepository.delete(trening);
    }
}