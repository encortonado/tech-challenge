package br.com.fiap.tech.challenge.infrastucture.handler;

import br.com.caelum.stella.validation.InvalidStateException;
import br.com.fiap.tech.challenge.domain.value_objects.enums.ECategoria;
import br.com.fiap.tech.challenge.infrastucture.exceptions.CustomErrorTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomErrorTypeException.class)
    public ResponseEntity<?> handleException(CustomErrorTypeException exception) {

        Map<String, Object> body = new HashMap<>();
        HttpStatus status;


        switch (exception.getMessage()) {
            case "Produto nao encontrado.":
                status = HttpStatus.NOT_FOUND;
                break;
            case "Cliente nao encontrado.":
                status = HttpStatus.NOT_FOUND;
                break;
            case "Cliente com dado CPF ja cadastrado":
                status = HttpStatus.BAD_REQUEST;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        body.put("errorType", status.value());
        body.put("message", exception.getMessage());

        return new ResponseEntity<>(body, status);

    }

    @ExceptionHandler(InvalidStateException.class)
    public ResponseEntity<?> handleCpfException(InvalidStateException exception) {

        Map<String, Object> body = new HashMap<>();

        body.put("message", exception.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    }
