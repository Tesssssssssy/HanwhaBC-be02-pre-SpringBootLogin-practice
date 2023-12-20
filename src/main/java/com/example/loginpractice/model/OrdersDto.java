package com.example.loginpractice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdersDto {
    Integer id;
    Member member;
    Product product;
}
