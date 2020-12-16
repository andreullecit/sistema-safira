package com.br.safira.sistema.sistemasafira.service;

import com.br.safira.sistema.sistemasafira.model.Customer;
import com.br.safira.sistema.sistemasafira.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.powermock.api.mockito.PowerMockito.when;


import java.util.Optional;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService = new CustomerService();;

    private final String idTest = "1";
    private final String firstNameTest = "Test";
    private final String lastNameTest = "Test";

    @Before
    public void setup(){

    }

    @Test
    public void customerNotFoundForDelete(){
        when(this.customerRepository.findById(idTest)).thenReturn(Optional.empty());
        boolean deleteCustomerResponse = this.customerService.deleteCustomer(idTest);
        assertFalse(deleteCustomerResponse);
    }

    @Test
    public void customerFoundForDelete(){
        when(this.customerRepository.findById(idTest)).thenReturn(Optional.of(Customer.builder()
                .firstName(firstNameTest)
                .lastName(lastNameTest)
                .build()));

        boolean deleteCustomerResponse = this.customerService.deleteCustomer(idTest);
        assertTrue(deleteCustomerResponse);
    }
}
