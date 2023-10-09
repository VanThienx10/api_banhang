package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "order1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id",updatable = false,insertable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_id",foreignKey = @ForeignKey(name = "fk_payment_order"))
    @JsonIgnoreProperties
    private Payment payment;


    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    @JsonIgnoreProperties
    private Set<OrderDetails> orderDetails;


    @ManyToOne
    @JoinColumn(name = "order_status_id",foreignKey = @ForeignKey(name = "fk_order_orderstatus"))
    @JsonIgnoreProperties
    private OrderStatus orderStatus;
}
