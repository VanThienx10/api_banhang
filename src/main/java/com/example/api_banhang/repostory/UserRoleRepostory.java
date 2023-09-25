package com.example.api_banhang.repostory;

import com.example.api_banhang.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepostory extends JpaRepository<UserRole,Integer> {
}
