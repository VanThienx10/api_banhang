package com.example.api_banhang.repostory;

import com.example.api_banhang.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepostory extends JpaRepository<ProductReview,Integer> {
}
