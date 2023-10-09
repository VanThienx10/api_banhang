package com.example.api_banhang.repostory;

import com.example.api_banhang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepostory extends JpaRepository<User,Integer> {
    Optional<User> findByEmailEquals(String eamail);

    Optional<User> findByUsername(String username);

}
