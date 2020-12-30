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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CandidateControllerTest {

    private CandidateRequest candidateTest;
    private CandidateRequest candidateTestWithoutNameField;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CandidateService candidateService;

    private String idTest="1";

    @Before
    public void setup() {
        this.candidateTest = CandidateRequest.builder()
                .fullName("Teste Teste")
                .description("Desenvolvedor java")
                .level(Level.Middle)
                .proficiency(1)
                .socialLinks("https://www.linkedin.com/")
                .build();

        this.candidateTestWithoutNameField = CandidateRequest.builder()
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
                .andExpect(MockMvcResultMatchers.content().string("Candidato cadastrado com sucesso!"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldReturnBadRequestForPost() throws Exception {
        String json = mapper.writeValueAsString(candidateTestWithoutNameField);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/candidate")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Erro no Cadastro do Candidato, por favor preencha os campos:\n" +
                        "fullName. "));
    }

    @Test
    public void shouldReturnOkForDelete() throws Exception {
        when(candidateService.deleteCandidate(this.idTest)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/candidate/{id}",idTest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string("Candidato excluido com sucesso!"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnBadRequestForDelete() throws Exception {
        when(candidateService.deleteCandidate(this.idTest)).thenReturn(false);
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/candidate/{id}",idTest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

