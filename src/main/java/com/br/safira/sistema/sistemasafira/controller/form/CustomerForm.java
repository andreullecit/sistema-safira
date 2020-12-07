package com.br.safira.sistema.sistemasafira.controller.form;

import com.br.safira.sistema.sistemasafira.model.Customer;
import com.br.safira.sistema.sistemasafira.repository.CustomerRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerForm {

    @Getter
    @Setter
    private LocalDate birthday;

    @Getter
    @Setter
    @NotNull @NotEmpty
    private String firstName;

    @Getter
    @NotNull @NotEmpty
    private String lastName;

    public Customer update(Customer customer, CustomerRepository customerRepository) {
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setBirthday(this.birthday);

        customerRepository.save(customer);

        return customer;
    }

}
