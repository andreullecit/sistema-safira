package com.br.safira.sistema.sistemasafira.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private LocalDateTime createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;


    @Override
    public String toString() {
        return String.format("Customer[id='%s', fistName='%s', lastName='%s']", id, firstName, lastName);
    }

}
