package com.example.api_banhang.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;
    private String payment_method;
    private int status;

    @OneToMany(mappedBy = "payment",fetch = FetchType.LAZY)
    private Set<Order> orders;

}
