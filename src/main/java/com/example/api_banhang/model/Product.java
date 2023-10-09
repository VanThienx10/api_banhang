package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tensanpham;
    private double price;
    private String anhsanpham;
    private String tieude;
    private int giamgia;
    private int status;
    private int view;

    @ManyToOne
    @JoinColumn(name = "lsp_id",foreignKey = @ForeignKey(name = "fk_sanpham_loaisanpham"))
    @JsonIgnoreProperties
    private LoaiSanPham loaiSanPham;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    @JsonIgnoreProperties
    private Set<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CartItem> cartItems;


    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductReview> productReviews;


}
