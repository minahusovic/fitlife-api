package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.VezbaRequest;
import com.it355.fitlife_api.entity.Vezba;
import com.it355.fitlife_api.repository.VezbaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VezbaServiceTest {

    @Mock
    private VezbaRepository vezbaRepository;

    @InjectMocks
    private VezbaService vezbaService;

    @Test
    void testGetAll() {
        Vezba v1 = new Vezba("Hip thrust", "Gluteus", "Vežba za gluteus", 6.0);
        Vezba v2 = new Vezba("RDL", "Zadnja loža", "Vežba za zadnju ložu", 5.0);

        when(vezbaRepository.findAll()).thenReturn(List.of(v1, v2));

        List<Vezba> rezultat = vezbaService.getAll();

        assertEquals(2, rezultat.size());
        assertEquals("Hip thrust", rezultat.get(0).getNaziv());
        verify(vezbaRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        Vezba vezba = new Vezba("Čučanj", "Noge", "Osnovna vežba za noge", 7.0);

        when(vezbaRepository.findById(1L)).thenReturn(Optional.of(vezba));

        Vezba rezultat = vezbaService.getById(1L);

        assertNotNull(rezultat);
        assertEquals("Čučanj", rezultat.getNaziv());
        verify(vezbaRepository, times(1)).findById(1L);
    }

    @Test
    void testCreate() {
        VezbaRequest request = new VezbaRequest();
        request.setNaziv("Hip thrust");
        request.setMisicnaGrupa("Gluteus");
        request.setOpis("Vežba za jačanje gluteusa.");
        request.setKalorijePoMinutu(6.0);

        Vezba sacuvana = new Vezba("Hip thrust", "Gluteus", "Vežba za jačanje gluteusa.", 6.0);
        sacuvana.setId(1L);

        when(vezbaRepository.save(any(Vezba.class))).thenReturn(sacuvana);

        Vezba rezultat = vezbaService.create(request);

        assertNotNull(rezultat);
        assertEquals(1L, rezultat.getId());
        assertEquals("Hip thrust", rezultat.getNaziv());
        verify(vezbaRepository, times(1)).save(any(Vezba.class));
    }

    @Test
    void testDelete() {
        Vezba vezba = new Vezba("RDL", "Zadnja loža", "Vežba za zadnju ložu", 5.0);
        vezba.setId(1L);

        when(vezbaRepository.findById(1L)).thenReturn(Optional.of(vezba));

        vezbaService.delete(1L);

        verify(vezbaRepository, times(1)).findById(1L);
        verify(vezbaRepository, times(1)).delete(vezba);
    }
}