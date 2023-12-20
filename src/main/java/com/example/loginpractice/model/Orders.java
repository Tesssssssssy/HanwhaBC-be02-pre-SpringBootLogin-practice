package com.example.loginpractice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "Member_id")
    private Member member;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_id")
    private Product product;
}
