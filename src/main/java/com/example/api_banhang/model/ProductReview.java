package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.service.spi.InjectService;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_review_id;
    private String content_rated;
    private int diemdanhgia;
    private String content_seen;
    private int status;

    @Column(name = "user_id")
    private int userId;
    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_product_product_review"))
    @JsonIgnoreProperties
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    @JsonIgnore
    private User user;


}
