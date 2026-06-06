package com.it355.fitlife_api.repository;

import com.it355.fitlife_api.entity.Trening;
import com.it355.fitlife_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {

    List<Trening> findByUser(User user);

    List<Trening> findByUserAndDatum(User user, LocalDate datum);
}