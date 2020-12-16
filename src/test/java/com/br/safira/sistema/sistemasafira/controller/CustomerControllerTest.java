package com.br.safira.sistema.sistemasafira.controller;

import com.br.safira.sistema.sistemasafira.service.CustomerService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        CustomerController.class,
        CustomerService.class,
})
public class CustomerControllerTest {
    private static final String DELETE_REQUEST = "/customer/1";

    @MockBean
    CustomerService customerService;

    @MockBean
    CustomerController customerRepository;

    @Autowired
    private CustomerController controller;

    @Test
    @Ignore
    public void test_notFoundDeleteCustomer() {

        when(this.customerService.deleteCustomer("1")).thenReturn(false);

        WebTestClient.bindToController(controller)
                .build()
                .get()
                .uri(DELETE_REQUEST)
                .exchange()
                .expectStatus().isNotFound();

    }



}
