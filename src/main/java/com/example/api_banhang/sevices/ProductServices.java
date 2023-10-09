package com.example.api_banhang.sevices;

import com.example.api_banhang.model.LoaiSanPham;
import com.example.api_banhang.model.Product;
import com.example.api_banhang.repostory.LoaiSanPhamRepostory;
import com.example.api_banhang.repostory.ProductRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductRepostory productRepostory;
    @Autowired
    private LoaiSanPhamRepostory loaiSanPhamRepostory;

    public String ThemSanPham(Product product){
        productRepostory.save(product);
        return "Them thanh cong !";

    }
    public String SuaSanPham(Product product){
        Optional<Product> sp = productRepostory.findById(product.getId());

        if (sp.isEmpty()){
            return "San pham ko ton tai !";
        }else {
            Product spCureent = sp.get();
            spCureent = product;
            productRepostory.save(spCureent);
            return "Sua thanh cong !";
        }
    }
    public String XoaSanPham(int id_sp){
        Optional<Product> sp = productRepostory.findById(id_sp);

        if (sp.isEmpty()){
            return "San pham ko ton tai !";
        }else {
            productRepostory.deleteById(id_sp);
            return "Xoa thanh cong !";
        }
    }

    public List<Product> GetAllSP(){
        return productRepostory.findAll();
    }

    public List<Product> HienThiSanPhamLienQuan(int id_sp){
        Product sp = productRepostory.findById(id_sp).get();
        LoaiSanPham lsp = loaiSanPhamRepostory.findById(sp.getLoaiSanPham().getId()).get();

        List<Product> lst = new ArrayList<>();

        for (Product x: productRepostory.findAll()){
            if (x.getLoaiSanPham().getId()==lsp.getId()){
                lst.add(x);
            }
        }
        return lst;
    }

    public List<Product> HienThiSPNoiBat(){
        List<Product> lst = new ArrayList<>();
        for (Product x: productRepostory.findAll()){
            if (x.getView() > 50){
                lst.add(x);
            }
        }
        return lst;
    }

}
