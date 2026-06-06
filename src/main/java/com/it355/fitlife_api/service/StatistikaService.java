package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.StatistikaResponse;
import com.it355.fitlife_api.entity.Obrok;
import com.it355.fitlife_api.entity.StavkaObroka;
import com.it355.fitlife_api.entity.Trening;
import com.it355.fitlife_api.entity.User;
import com.it355.fitlife_api.repository.ObrokRepository;
import com.it355.fitlife_api.repository.TreningRepository;
import com.it355.fitlife_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatistikaService {

    private final UserRepository userRepository;
    private final ObrokRepository obrokRepository;
    private final TreningRepository treningRepository;

    public StatistikaService(UserRepository userRepository,
                             ObrokRepository obrokRepository,
                             TreningRepository treningRepository) {
        this.userRepository = userRepository;
        this.obrokRepository = obrokRepository;
        this.treningRepository = treningRepository;
    }

    @Transactional(readOnly = true)
    public StatistikaResponse getDnevnaStatistika(Long userId, LocalDate datum) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Korisnik nije pronađen."));

        List<Obrok> obroci = obrokRepository.findByUserAndDatum(user, datum);
        List<Trening> treninzi = treningRepository.findByUserAndDatum(user, datum);

        double ukupneKalorije = 0.0;
        double ukupniProteini = 0.0;

        for (Obrok obrok : obroci) {
            for (StavkaObroka stavka : obrok.getStavke()) {

                double kolicina = stavka.getKolicinaGrama() / 100.0;

                ukupneKalorije += stavka.getNamirnica().getKalorijeNa100g() * kolicina;
                ukupniProteini += stavka.getNamirnica().getProteiniNa100g() * kolicina;
            }
        }

        double potroseneKalorije = 0.0;

        for (Trening trening : treninzi) {
            if (trening.getPotroseneKalorije() != null) {
                potroseneKalorije += trening.getPotroseneKalorije();
            }
        }

        double netoKalorije = ukupneKalorije - potroseneKalorije;

        return new StatistikaResponse(
                userId,
                datum,
                ukupneKalorije,
                ukupniProteini,
                potroseneKalorije,
                netoKalorije
        );
    }
}