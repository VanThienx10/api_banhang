package com.example.api_banhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.service.spi.InjectService;

@Getter
@Setter
@Entity
@Table
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_review_id;
    private String content_rated;
    private int diemdanhgia;
    private String content_seen;
    private int status;


    @ManyToOne
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_product_product_review"))
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "fk_user_product_review"))
    @JsonIgnore
    private User user;


}
