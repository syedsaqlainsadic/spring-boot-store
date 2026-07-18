package com.firstspringproject.store.services;

import java.util.UUID;


import org.springframework.stereotype.Service;

import com.firstspringproject.store.dto.CartDto;
import com.firstspringproject.store.dto.CartItemsDto;
import com.firstspringproject.store.entities.Cart;
import com.firstspringproject.store.exceptions.CartNotFoundException;
import com.firstspringproject.store.exceptions.ProductNotFoundException;
import com.firstspringproject.store.mappers.CartMapper;
import com.firstspringproject.store.repositories.CartRepository;
import com.firstspringproject.store.repositories.ProductRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private CartMapper cartMapper;

    public CartDto createCart(){
         var cart = new Cart();
        cartRepository.save(cart);
        return cartMapper.tDto(cart);
    }

    public CartItemsDto addToCart(UUID cartId , Long productId){
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }

        var product = productRepository.findById(productId).orElse(null);

        if (product == null) {
            throw new ProductNotFoundException();
        }

        var cartItem = cart.addItem(product);

        cartRepository.save(cart);
        return cartMapper.toDto(cartItem);
    }

    public CartDto viewCart(UUID cartId){
         var cart = cartRepository.getCartWithItems(cartId).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        return cartMapper.tDto(cart);
    }

    public CartItemsDto updateCart(UUID cartId , Long productId,Integer quantity){
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }

        var cartItem = cart.getItem(productId);

        if (cartItem == null) {
            throw new ProductNotFoundException();
        }
        cartItem.setQuantity(quantity);
        cartRepository.save(cart);

        return cartMapper.toDto(cartItem);
    }

    public Void deleteCartItem(UUID cartId , Long productId){
        var cart = cartRepository.findById(cartId).orElse(null);

        if (cart == null) {
            throw new CartNotFoundException();
        }

        cart.removeItem(productId);
        cartRepository.save(cart);

        return null;
    }

    public Void clearCart(UUID cartId){
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }

        cart.clear(cartId);

        cartRepository.save(cart);

        return null;
    }

}
