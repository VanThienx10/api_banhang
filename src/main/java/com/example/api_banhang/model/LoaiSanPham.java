package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "loáianpham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    private String tenloaisanpham;
    private String anhloaisanpham;

    @OneToMany(mappedBy = "loaiSanPham",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products;

}
