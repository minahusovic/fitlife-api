package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.ObrokRequest;
import com.it355.fitlife_api.entity.Obrok;
import com.it355.fitlife_api.entity.User;
import com.it355.fitlife_api.repository.ObrokRepository;
import com.it355.fitlife_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ObrokService {

    private final ObrokRepository obrokRepository;
    private final UserRepository userRepository;

    public ObrokService(ObrokRepository obrokRepository, UserRepository userRepository) {
        this.obrokRepository = obrokRepository;
        this.userRepository = userRepository;
    }

    public List<Obrok> getAll() {
        return obrokRepository.findAll();
    }

    public Obrok getById(Long id) {
        return obrokRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Obrok nije pronađen."));
    }

    public List<Obrok> getByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Korisnik nije pronađen."));

        return obrokRepository.findByUser(user);
    }

    @Transactional
    public Obrok create(ObrokRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Korisnik nije pronađen."));

        Obrok obrok = new Obrok(
                request.getNaziv(),
                request.getDatum(),
                request.getTipObroka(),
                user
        );

        return obrokRepository.save(obrok);
    }

    @Transactional
    public void delete(Long id) {
        Obrok obrok = getById(id);
        obrokRepository.delete(obrok);
    }
}