package com.example.productservice.exceptions;

import com.example.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundExceptionHandler(NotFoundException e){
        return new ResponseEntity<>(new ExceptionDto(e.getMessage(), HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }

}
