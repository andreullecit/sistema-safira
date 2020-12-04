package com.br.safira.sistema.sistemasafira.controller;

import com.br.safira.sistema.sistemasafira.controller.form.CustomerForm;
import com.br.safira.sistema.sistemasafira.model.Customer;
import com.br.safira.sistema.sistemasafira.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody @Valid CustomerForm newCustomer) {
        Customer customer = new Customer(newCustomer.getFirstName(), newCustomer.getLastName(), newCustomer.getBirthday());
        customerRepository.save(customer);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id ,@RequestBody @Valid CustomerForm updatedCustomer) {
        Optional<Customer> optional = customerRepository.findById(id);
        if(optional.isPresent()) {
            Customer customer  = updatedCustomer.update(optional.get(), customerRepository);
            return ResponseEntity.ok(customer);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        Optional<Customer> optional = customerRepository.findById(id);
        if(optional.isPresent()){
            customerRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}


