package com.br.safira.sistema.sistemasafira.controller;

import com.br.safira.sistema.sistemasafira.controller.form.CustomerForm;
import com.br.safira.sistema.sistemasafira.model.Customer;
import com.br.safira.sistema.sistemasafira.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody @Valid CustomerForm customerRequest) {

        customerService.saveCustomer(convertRequestToModel(customerRequest));

        return ResponseEntity.ok().build();
    }



    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id ,@RequestBody @Valid CustomerForm updatedCustomer) {
        if(this.customerService.updateCustomer(this.convertRequestToModel(updatedCustomer))) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        if(this.customerService.deleteCustomer(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Customer convertRequestToModel(CustomerForm customerRequest) {
        return Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .birthday(customerRequest.getBirthday())
                .build();
    }

}


