package com.example.loginpractice.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MemberDtoPost {
    Integer id;
    String email;
    String password;
}
