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
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_item_id;
    private int soluong;

    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_product_cartitem"))
    @JsonIgnoreProperties
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id",foreignKey = @ForeignKey(name = "fk_cart_cart_item"))
    @JsonBackReference
    private Cart cart;

}
