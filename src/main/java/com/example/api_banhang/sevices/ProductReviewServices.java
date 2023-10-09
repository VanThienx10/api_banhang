package com.example.api_banhang.sevices;

import com.example.api_banhang.model.Product;
import com.example.api_banhang.model.ProductReview;
import com.example.api_banhang.repostory.ProductRepostory;
import com.example.api_banhang.repostory.ProductReviewRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductReviewServices {
    @Autowired
    private ProductReviewRepostory productReviewRepostory;

    @Autowired
    private ProductRepostory productRepostory;


    public String ThemDanhGia(ProductReview productReview){

        productReviewRepostory.save(productReview);
        return "Them thanh cong!";
    }

    public String SuaDanhGia(ProductReview productReview){
        Optional<ProductReview> pr = productReviewRepostory.findById(productReview.getProduct_review_id());
        if (pr.isEmpty()){
            return "Danh gia khong ton tai!";
        }else {
            ProductReview prCurrent = pr.get();
            prCurrent = productReview;
            productReviewRepostory.save(prCurrent);
            return "Sua thanh cong !";
        }
    }

    public String XoaDanhGia(int id_pr){
        Optional<ProductReview> pr = productReviewRepostory.findById(id_pr);
        if (pr.isEmpty()){
            return "Danh gia khong ton tai!";
        }
        productReviewRepostory.deleteById(id_pr);
        return "Xoa thanh cong !";
    }

    public int HienThiSoLuotXemSP(int id_sp){
        Product sp = productRepostory.findById(id_sp).get();
        return sp.getView();
    }





}
