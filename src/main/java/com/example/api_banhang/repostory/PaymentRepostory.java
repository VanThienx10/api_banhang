package com.example.api_banhang.repostory;

import com.example.api_banhang.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepostory extends JpaRepository<Payment,Integer> {
}
