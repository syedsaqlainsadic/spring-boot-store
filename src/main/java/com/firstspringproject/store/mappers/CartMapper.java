package com.firstspringproject.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.firstspringproject.store.dto.CartDto;
import com.firstspringproject.store.dto.CartItemsDto;
import com.firstspringproject.store.entities.Cart;
import com.firstspringproject.store.entities.CartItem;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "totalprice", expression = "java(cart.getTotalPrice())")
    CartDto tDto(Cart cart);

    @Mapping(target = "totalPrice", expression = "java(cartItems.getTotalPrice())")
    CartItemsDto toDto(CartItem cartItems);


}
