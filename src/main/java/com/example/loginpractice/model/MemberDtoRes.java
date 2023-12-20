package com.example.loginpractice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDtoRes {
    Integer id;
    String email;
}
