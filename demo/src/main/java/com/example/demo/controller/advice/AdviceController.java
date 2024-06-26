package com.example.demo.controller.advice;

import com.example.demo.exception.DataNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@ControllerAdvice
public class AdviceController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public String handleConstrainViolationException(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        if (constraintViolations.isEmpty()) {
            return "Constraint validation exception";
        }
        return constraintViolations.stream()
                .map(ConstraintViolation::getMessageTemplate)
                .filter(message -> message != null && !message.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        if (fieldErrors.isEmpty()) {
            return "Constraint validation exception";
        }
        return fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .filter(message -> message != null && !message.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DataNotFoundException.class)
    public String handleDataNotFoundException(DataNotFoundException exception) {
        return exception.getMessage() == null ? "Data not found exception" : exception.getMessage();
    }

}
