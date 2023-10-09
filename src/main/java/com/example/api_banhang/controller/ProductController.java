package com.example.api_banhang.controller;

import com.example.api_banhang.model.Product;
import com.example.api_banhang.sevices.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @PostMapping(value = "product/them")
    public String ThemSanPham(@RequestBody Product product){
        return productServices.ThemSanPham(product);
    }

    @PutMapping(value = "product/sua")
    public String SuaSanPham(@RequestBody Product product){
        return productServices.SuaSanPham(product);
    }

    @DeleteMapping(value = "product/xoa")
    public String XoaSanPham(@RequestParam int id_sp){
        return productServices.XoaSanPham(id_sp);
    }

    @GetMapping(value = "product/getall")
    public List<Product> HienThiDSSP(){
        return productServices.GetAllSP();
    }

    @GetMapping(value = "product/hienthisanphamlienqua")
    public List<Product> HienThiSPLienQuan(@RequestParam int id_sp){
        return productServices.HienThiSanPhamLienQuan(id_sp);
    }

    @GetMapping(value = "product/hienthisanphamnoibat")
    public List<Product> HienThiSanPhamNoiBat(){
        return productServices.HienThiSPNoiBat();
    }


}
