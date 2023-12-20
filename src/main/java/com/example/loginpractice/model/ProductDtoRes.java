package com.example.loginpractice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDtoRes {
    Integer id;
    String name;
    Integer price;
}
