package com.example.api_banhang.controller;

import com.example.api_banhang.model.LoaiSanPham;
import com.example.api_banhang.sevices.LoaiSanPhamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoaiSanPhamController {
    @Autowired
    private LoaiSanPhamServices loaiSanPhamServices;

    @PostMapping(value = "loaisanpham/them")
    public String ThemLoaiSanPham(@RequestBody LoaiSanPham loaiSanPham){
        return loaiSanPhamServices.ThemLoaiSanPham(loaiSanPham);
    }

    @PutMapping(value = "loaisanpham/sua")
    public String SuaLoaiSanPham(@RequestBody LoaiSanPham loaiSanPham){
        return loaiSanPhamServices.SuaLoaiSanPHam(loaiSanPham);
    }

    @DeleteMapping(value = "loaisanpham/xoa")
    public String XoaLoaiSanPham(@RequestParam int id_lsp){
        return loaiSanPhamServices.XoaLoaiSanPHam(id_lsp);
    }

    @GetMapping(value = "loaisanpham/getall")
    public List<LoaiSanPham> HienThiDSLSP(){
        return loaiSanPhamServices.GetAllLSP();
    }
}
