package com.example.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionDto {
    private String message;
    private HttpStatus errCode;
    private List<String> errors;
}
