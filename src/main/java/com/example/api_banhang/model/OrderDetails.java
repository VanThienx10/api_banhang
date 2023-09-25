package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double tongtien;
    private int soluong;

    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_sanpham_order_details"))
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "fk_order_order_details"))
    @JsonIgnore
    private Order order;

}
