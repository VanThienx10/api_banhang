package com.example.api_banhang.repostory;

import com.example.api_banhang.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepostory extends JpaRepository<Order,Integer> {
}
