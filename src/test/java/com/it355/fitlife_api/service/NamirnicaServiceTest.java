package com.it355.fitlife_api.service;

import com.it355.fitlife_api.dto.NamirnicaRequest;
import com.it355.fitlife_api.entity.Namirnica;
import com.it355.fitlife_api.repository.NamirnicaRepository;
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
public class NamirnicaServiceTest {

    @Mock
    private NamirnicaRepository namirnicaRepository;

    @InjectMocks
    private NamirnicaService namirnicaService;

    @Test
    void testGetAll() {
        Namirnica n1 = new Namirnica("Pileca prsa", 110.0, 23.0, 0.0, 2.0);
        Namirnica n2 = new Namirnica("Jaja", 155.0, 13.0, 1.0, 11.0);

        when(namirnicaRepository.findAll()).thenReturn(List.of(n1, n2));

        List<Namirnica> rezultat = namirnicaService.getAll();

        assertEquals(2, rezultat.size());
        assertEquals("Pileca prsa", rezultat.get(0).getNaziv());
        verify(namirnicaRepository, times(1)).findAll();
    }

    @Test
    void testGetById() {
        Namirnica namirnica = new Namirnica("Ovsene pahuljice", 370.0, 13.0, 60.0, 7.0);

        when(namirnicaRepository.findById(1L)).thenReturn(Optional.of(namirnica));

        Namirnica rezultat = namirnicaService.getById(1L);

        assertNotNull(rezultat);
        assertEquals("Ovsene pahuljice", rezultat.getNaziv());
        verify(namirnicaRepository, times(1)).findById(1L);
    }

    @Test
    void testCreate() {
        NamirnicaRequest request = new NamirnicaRequest();
        request.setNaziv("Banana");
        request.setKalorijeNa100g(89.0);
        request.setProteiniNa100g(1.1);
        request.setUgljeniHidratiNa100g(23.0);
        request.setMastiNa100g(0.3);

        Namirnica sacuvana = new Namirnica("Banana", 89.0, 1.1, 23.0, 0.3);
        sacuvana.setId(1L);

        when(namirnicaRepository.save(any(Namirnica.class))).thenReturn(sacuvana);

        Namirnica rezultat = namirnicaService.create(request);

        assertNotNull(rezultat);
        assertEquals(1L, rezultat.getId());
        assertEquals("Banana", rezultat.getNaziv());
        verify(namirnicaRepository, times(1)).save(any(Namirnica.class));
    }

    @Test
    void testDelete() {
        Namirnica namirnica = new Namirnica("Pirinač", 130.0, 2.7, 28.0, 0.3);
        namirnica.setId(1L);

        when(namirnicaRepository.findById(1L)).thenReturn(Optional.of(namirnica));

        namirnicaService.delete(1L);

        verify(namirnicaRepository, times(1)).findById(1L);
        verify(namirnicaRepository, times(1)).delete(namirnica);
    }
}