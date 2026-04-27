package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class ProductDTO{
    private String name;
    private BigDecimal price;
}
