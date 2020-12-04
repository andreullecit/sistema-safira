package com.br.safira.sistema.sistemasafira.config.validation;

import lombok.Getter;

public class ValidationErrorDto {

    @Getter
    private final String error;
    @Getter
    private final String field;

    public ValidationErrorDto(String error, String field) {
        this.error = error;
        this.field = field;
    }
}
