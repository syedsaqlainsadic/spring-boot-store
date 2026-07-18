package com.firstspringproject.store.services;


import org.springframework.stereotype.Service;

import com.firstspringproject.store.dto.CheckoutRequest;
import com.firstspringproject.store.dto.CheckoutResponse;

import com.firstspringproject.store.entities.Order;
import com.firstspringproject.store.exceptions.CartEmptyException;
import com.firstspringproject.store.exceptions.CartNotFoundException;
import com.firstspringproject.store.repositories.CartRepository;
import com.firstspringproject.store.repositories.OrderRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CheckoutService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final AuthService authService;


    public CheckoutResponse checkout(CheckoutRequest request){
        var cart = cartRepository.getCartWithItems(request.getCartId()).orElse(null);

        if (cart == null) {
           throw new CartNotFoundException();
        }

        if (cart.isEmpty()) {
           throw new CartEmptyException();
        }

        var order = Order.fromCart(cart, authService.getCurrentUser());

        orderRepository.save(order);

        return new CheckoutResponse(order.getId());
    }

}
