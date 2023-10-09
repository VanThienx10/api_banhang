package com.example.api_banhang.controller;

import com.example.api_banhang.model.Order;
import com.example.api_banhang.sevices.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @PostMapping (value = "order/them",produces = MediaType.APPLICATION_JSON_VALUE)
    public String ThemDonHang(@RequestBody Order order){
        return orderServices.DatDonHang(order);
    }
    @GetMapping(value = "order/hienthidsdonhang",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> HienThiDSDonHang(@RequestParam int id_user){
        return orderServices.HienThiDSDonHang( id_user);
    }
}
