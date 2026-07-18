package com.firstspringproject.store.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckoutRequest {

    @NotNull(message = "Cart Id is required.")
    private UUID cartId;

}
