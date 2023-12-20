package com.example.loginpractice.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDtoPost {
    Integer id;
    String name;
    Integer price;
}
