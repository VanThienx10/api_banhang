package com.example.api_banhang.repostory;

import com.example.api_banhang.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepostory extends JpaRepository<Cart,Integer> {
}
