package com.example.api_banhang.repostory;

import com.example.api_banhang.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepostory extends JpaRepository<Role,Integer> {
    @Query("""
           from Role r join UserRole ur on r.id = ur.role.id where ur.user.id = :nguoiDungId
            """)
    List<Role> getAllQuyen(int nguoiDungId);

    Optional<Role> findByName(String name);
}
