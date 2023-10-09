package com.example.api_banhang.controller;

import com.example.api_banhang.model.Cart;
import com.example.api_banhang.sevices.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    private CartServices cartServices;

    @PostMapping(value = "cart/them", consumes = {"application/json"})
    public String ThemGioHang(@RequestBody Cart cart){
        return cartServices.ThemGioHang(cart);
    };
}
