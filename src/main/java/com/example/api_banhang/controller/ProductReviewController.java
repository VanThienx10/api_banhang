package com.example.api_banhang.controller;

import com.example.api_banhang.model.ProductReview;
import com.example.api_banhang.sevices.ProductReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductReviewController {

    @Autowired
    private ProductReviewServices productReviewServices;

    @PostMapping(value = "danhgia/them")
    public String ThemDanhGia(@RequestBody ProductReview productReview){
        return productReviewServices.ThemDanhGia(productReview);
    }

    @PutMapping(value = "danhgia/sua")
    public String SuaDanhGia(@RequestBody ProductReview productReview){
        return productReviewServices.SuaDanhGia(productReview);
    }

    @DeleteMapping(value = "danhgia/xoa")
    public String XoaDanhGia(@RequestParam int id_pr){
        return productReviewServices.XoaDanhGia(id_pr);
    }

    @GetMapping(value = "danhgia/hienthidiemSP")
    public int HienThiDiemSP(@RequestParam int id_sp){
        return productReviewServices.HienThiSoLuotXemSP(id_sp);
    }
}
