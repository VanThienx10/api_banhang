package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;
    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    @JsonIgnore
    private User user;


    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<CartItem> cartItems;

}
