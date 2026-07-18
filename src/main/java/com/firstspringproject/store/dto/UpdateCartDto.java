package com.firstspringproject.store.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCartDto {

    @NotNull(message = "Quantity must be provided.")
    @Min(value = 1 , message = "Quantity must be greater than 0.")
    @Max(value = 100, message = "Maximum quantity allowed is 100.")
    private Integer quantity;

}
