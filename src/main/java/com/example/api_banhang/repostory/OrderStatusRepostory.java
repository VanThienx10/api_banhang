package com.example.api_banhang.repostory;

import com.example.api_banhang.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepostory extends JpaRepository<OrderStatus,Integer> {
}
