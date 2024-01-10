package com.example.productservice.exceptions;

import com.example.productservice.dtos.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundExceptionHandler(NotFoundException e) {
        return new ResponseEntity<>(new ExceptionDto(e.getMessage(), HttpStatus.NOT_FOUND, new ArrayList<>()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> notValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        e.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));
        return new ResponseEntity<>(new ExceptionDto("Invalid Request Body", HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST);
    }

}
