package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double tongtien;
    private int soluong;

    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_sanpham_order_details"))
    @JsonIgnoreProperties
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "fk_order_order_details"))
    @JsonIgnore
    private Order order;

}
