package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private double giagoc;
    private double giathucte;
    private String fullname;
    private String email;
    private String phone;
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "fk_user_order"))
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_id",foreignKey = @ForeignKey(name = "fk_payment_order"))
    @JsonIgnore
    private Payment payment;


    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderDetails> orderDetails;
}
