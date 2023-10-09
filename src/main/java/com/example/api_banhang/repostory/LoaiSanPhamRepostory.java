package com.example.api_banhang.repostory;

import com.example.api_banhang.model.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSanPhamRepostory extends JpaRepository<LoaiSanPham,Integer> {
}
