package com.splitcart.product.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public Mono<ResponseEntity<Void>> handleNotFoundException(
            NoSuchElementException ex) {

        return Mono.just(
                ResponseEntity.notFound().build()
        );
    }

    @ExceptionHandler(ResponseStatusException.class)
    public Mono<ResponseEntity<Void>> handleResponseStatusException(
            ResponseStatusException ex) {

        return Mono.just(
                ResponseEntity.status(ex.getStatusCode()).build()
        );
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<Void>> handleGenericException(
            Exception ex) {

        return Mono.just(
                ResponseEntity.internalServerError().build()
        );
    }
}