package com.br.safira.sistema.sistemasafira.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Configuration
@PropertySource("classpath:application.properties")
public class ValidationErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @Value("${VALIDATION_REQUIRED_FIELDS}")
    private String validationMessage;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handle(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        StringBuilder message = new StringBuilder();
        message.append(validationMessage);
        fieldErrors.forEach(e-> {
            message.append(e.getField()).append(", ");
        });
        return message.toString();
    }

}
