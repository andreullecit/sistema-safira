package com.br.safira.sistema.sistemasafira.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @JsonFormat(pattern = "dd/MM/yy HH:mm:ss")
    private LocalDateTime createdAt;

    @Getter
    @Setter
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    public Customer() {}

    public Customer(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Customer[id='%s', fistName='%s', lastName='%s']", id, firstName, lastName);
    }

}
