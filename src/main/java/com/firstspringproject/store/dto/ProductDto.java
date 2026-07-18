package com.firstspringproject.store.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Byte categoryid;
}
