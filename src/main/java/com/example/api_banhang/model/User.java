package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.service.spi.InjectService;

import java.util.Set;

@Table(name = "user")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String password;
    private String address;
    private String avartar;
    private Integer status;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductReview> productReviews;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Order> orders;


    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Cart> carts;



}
