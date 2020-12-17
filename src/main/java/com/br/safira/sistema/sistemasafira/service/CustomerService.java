package com.br.safira.sistema.sistemasafira.service;

import com.br.safira.sistema.sistemasafira.model.Customer;
import com.br.safira.sistema.sistemasafira.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomer(Customer customer){
        this.customerRepository.save(customer);
    }

    public List<Customer> findAll(){
            return customerRepository.findAll();
    }

    public boolean deleteCustomer(String id){
        Optional<Customer> optional = customerRepository.findById(id);
        if(optional.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean updateCustomer(Customer customer){
        Optional<Customer> optional = customerRepository.findById(customer.getId());
        if(optional.isPresent()) {
            customerRepository.save(customer);
            return true;
        }

        return false;
    }


}
