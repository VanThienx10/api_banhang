package com.example.api_banhang.repostory;

import com.example.api_banhang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepostory extends JpaRepository<Product,Integer> {
}
