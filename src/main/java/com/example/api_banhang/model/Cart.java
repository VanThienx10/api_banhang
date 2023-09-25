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
public class Cart {
    @Id
    @GeneratedValue
    private int cart_id;

    @ManyToOne
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "fk_user_cart"))
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CartItem> cartItems;

}
