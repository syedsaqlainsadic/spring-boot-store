package com.firstspringproject.store.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstspringproject.store.dto.CheckoutRequest;
import com.firstspringproject.store.dto.CheckoutResponse;
import com.firstspringproject.store.dto.ErrorDto;

import com.firstspringproject.store.exceptions.CartEmptyException;
import com.firstspringproject.store.exceptions.CartNotFoundException;

import com.firstspringproject.store.services.CheckoutService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {
 
    private final CheckoutService checkoutService;

    @PostMapping
    public CheckoutResponse checkout( @Valid @RequestBody CheckoutRequest request) {
                return checkoutService.checkout(request);
        
    }

    @ExceptionHandler({CartNotFoundException.class,CartEmptyException.class})
    public ResponseEntity<ErrorDto> handleException(Exception ex){
        return ResponseEntity.badRequest().body(new ErrorDto(ex.getMessage()));
    }

}
