package com.it355.fitlife_api.repository;

import com.it355.fitlife_api.entity.Obrok;
import com.it355.fitlife_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ObrokRepository extends JpaRepository<Obrok, Long> {

    List<Obrok> findByUser(User user);

    List<Obrok> findByUserAndDatum(User user, LocalDate datum);
}