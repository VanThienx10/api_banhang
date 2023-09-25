package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_item_id;
    private int soluong;

    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_product_cartitem"))
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id",foreignKey = @ForeignKey(name = "fk_cart_cart_item"))
    @JsonIgnore
    private Cart cart;

}
