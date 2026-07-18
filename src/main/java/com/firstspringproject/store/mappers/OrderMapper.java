package com.firstspringproject.store.mappers;

import org.mapstruct.Mapper;

import com.firstspringproject.store.dto.OrderDto;
import com.firstspringproject.store.entities.Order;

@Mapper(componentModel ="spring" )
public interface OrderMapper {
    OrderDto toDto(Order order);
}
