package com.br.safira.sistema.sistemasafira.controller;

import com.br.safira.sistema.sistemasafira.controller.request.CandidateRequest;
import com.br.safira.sistema.sistemasafira.model.enums.Level;
import com.br.safira.sistema.sistemasafira.service.CandidateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CandidateControllerTest {

    private CandidateRequest candidateTest;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CandidateService candidateService;

    @Before
    public void setup() {
        this.candidateTest = CandidateRequest.builder()
                .fullName("Teste Teste")
                .description("Desenvolvedor java")
                .level(Level.Middle)
                .proficiency(1)
                .socialLinks("https://www.linkedin.com/")
                .build();
    }

    @Test
    public void shouldReturnOkWhenGettingByStatus() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/candidate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnOkForPost() throws Exception {
        String json = mapper.writeValueAsString(candidateTest);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/candidate")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnBadRequestForPost() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/candidate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}

