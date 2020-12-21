package com.br.safira.sistema.sistemasafira.controller;

import com.br.safira.sistema.sistemasafira.controller.form.CustomerForm;
import com.br.safira.sistema.sistemasafira.model.Customer;
import com.br.safira.sistema.sistemasafira.service.CustomerService;
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

import java.time.LocalDate;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    private String idTest = "1";
    private final String firstNameTest = "Test";
    private final String lastNameTest = "Test";
    private final LocalDate birthdayTest = LocalDate.now();
    private Customer customerTest;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CustomerService customerService;

    @Before
    public void setup() {
        this.customerTest = Customer.builder()
                .firstName(firstNameTest)
                .lastName(lastNameTest)
                .birthday(birthdayTest)
                .build();
    }

    @Test
    public void shouldReturnNotFoundForDelete() throws Exception {
        when(customerService.deleteCustomer(this.idTest)).thenReturn(false);

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/customer/{id}", idTest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void shouldReturnOkForDelete() throws Exception {
        when(customerService.deleteCustomer(idTest)).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/customer/{id}", idTest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnBadRequestForPost() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldReturnOkForPost() throws Exception {
        String json = mapper.writeValueAsString(customerTest);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/customer")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnOkForPut() throws Exception {
        when(customerService.updateCustomer(customerTest)).thenReturn(true);

        customerTest.setId("1");

        String json = mapper.writeValueAsString(customerTest);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/customer/{id}", idTest)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnNotFoundForPut() throws Exception {
        when(customerService.updateCustomer(customerTest)).thenReturn(false);

        String json = mapper.writeValueAsString(customerTest);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/customer/{id}", idTest)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void shouldReturnBadRequestForPut() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/customer/{id}", idTest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}

