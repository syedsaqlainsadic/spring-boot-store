package com.firstspringproject.store.controllers;

import java.util.UUID;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.firstspringproject.store.dto.AddItemstoCart;
import com.firstspringproject.store.dto.CartDto;
import com.firstspringproject.store.dto.CartItemsDto;
import com.firstspringproject.store.dto.UpdateCartDto;
import com.firstspringproject.store.exceptions.CartNotFoundException;
import com.firstspringproject.store.exceptions.ProductNotFoundException;
import com.firstspringproject.store.services.CartService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/carts")
@Tag(name = "Carts")
public class CartController {
    private CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCart(
            UriComponentsBuilder uriBuilder) {

        var cartDto = cartService.createCart();
        var uri = uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId()).toUri();
        return ResponseEntity.created(uri).body(cartDto);
    }

    @PostMapping("/{cartId}/items")
    @Operation(summary = "Add products to the cart.")
    public ResponseEntity<CartItemsDto> addToCart(
        @Parameter(description = "The ID of the cart.")
            @PathVariable UUID cartId,
            @RequestBody AddItemstoCart request) {

        var cartItemDto = cartService.addToCart(cartId, request.getProductId());
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

    @GetMapping("/{cartId}")
    public CartDto getCart(
            @PathVariable UUID cartId) {
        return cartService.viewCart(cartId);
    }

    @PutMapping("/{cartId}/items/{productId}")
    public CartItemsDto updateCart(
            @PathVariable UUID cartId,
            @PathVariable Long productId,
            @Valid @RequestBody UpdateCartDto request) {
        
        return  cartService.updateCart(cartId, productId, request.getQuantity());
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public ResponseEntity<?> deleteCart(
            @PathVariable UUID cartId,
            @PathVariable Long productId) {
        
         cartService.deleteCartItem(cartId, productId);
         return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{cartId}/items")
    public ResponseEntity<Void> clearCart(@PathVariable UUID cartId) {
        cartService.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCartNotFounf() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error", "Cart Not Found"));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFOundException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "Product not found in cart"));
    }
}
