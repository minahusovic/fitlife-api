package com.it355.fitlife_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.it355.fitlife_api.dto.NamirnicaRequest;
import com.it355.fitlife_api.entity.Namirnica;
import com.it355.fitlife_api.service.NamirnicaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class NamirnicaControllerTest {

    private MockMvc mockMvc;
    private NamirnicaService namirnicaService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        namirnicaService = Mockito.mock(NamirnicaService.class);
        NamirnicaController namirnicaController = new NamirnicaController(namirnicaService);
        mockMvc = MockMvcBuilders.standaloneSetup(namirnicaController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllNamirnice() throws Exception {
        Namirnica n1 = new Namirnica("Pileca prsa", 110.0, 23.0, 0.0, 2.0);
        n1.setId(1L);

        Namirnica n2 = new Namirnica("Jaja", 155.0, 13.0, 1.0, 11.0);
        n2.setId(2L);

        Mockito.when(namirnicaService.getAll()).thenReturn(List.of(n1, n2));

        mockMvc.perform(get("/api/namirnice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].naziv").value("Pileca prsa"));
    }

    @Test
    void testGetNamirnicaById() throws Exception {
        Namirnica namirnica = new Namirnica("Banana", 89.0, 1.1, 23.0, 0.3);
        namirnica.setId(1L);

        Mockito.when(namirnicaService.getById(1L)).thenReturn(namirnica);

        mockMvc.perform(get("/api/namirnice/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.naziv").value("Banana"));
    }

    @Test
    void testCreateNamirnica() throws Exception {
        NamirnicaRequest request = new NamirnicaRequest();
        request.setNaziv("Ovsene pahuljice");
        request.setKalorijeNa100g(370.0);
        request.setProteiniNa100g(13.0);
        request.setUgljeniHidratiNa100g(60.0);
        request.setMastiNa100g(7.0);

        Namirnica saved = new Namirnica("Ovsene pahuljice", 370.0, 13.0, 60.0, 7.0);
        saved.setId(1L);

        Mockito.when(namirnicaService.create(any(NamirnicaRequest.class))).thenReturn(saved);

        mockMvc.perform(post("/api/namirnice")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.naziv").value("Ovsene pahuljice"));
    }

    @Test
    void testUpdateNamirnica() throws Exception {
        NamirnicaRequest request = new NamirnicaRequest();
        request.setNaziv("Pirinač");
        request.setKalorijeNa100g(130.0);
        request.setProteiniNa100g(2.7);
        request.setUgljeniHidratiNa100g(28.0);
        request.setMastiNa100g(0.3);

        Namirnica updated = new Namirnica("Pirinač", 130.0, 2.7, 28.0, 0.3);
        updated.setId(1L);

        Mockito.when(namirnicaService.update(eq(1L), any(NamirnicaRequest.class))).thenReturn(updated);

        mockMvc.perform(put("/api/namirnice/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.naziv").value("Pirinač"));
    }

    @Test
    void testDeleteNamirnica() throws Exception {
        mockMvc.perform(delete("/api/namirnice/1"))
                .andExpect(status().isNoContent());

        Mockito.verify(namirnicaService, Mockito.times(1)).delete(1L);
    }
}