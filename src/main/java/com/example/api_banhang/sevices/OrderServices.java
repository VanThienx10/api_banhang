package com.example.api_banhang.sevices;


import com.example.api_banhang.model.*;
import com.example.api_banhang.repostory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServices {
    @Autowired
    private OrderRepostory orderRepostory;
    @Autowired
    private OrderDetailRepostory orderDetailRepostory;
    @Autowired
    private UserRepostory userRepostory;

    @Autowired
    private OrderStatusRepostory orderStatusRepostory;
    @Autowired
    private ProductRepostory productRepostory;



    public String DatDonHang(Order order){
        User user = userRepostory.findById(order.getUserId()).get();
        order.setFullname(user.getUsername());
        order.setEmail(user.getEmail());
        order.setAddress(user.getAddress());
        orderRepostory.save(order);
        for (OrderDetails od: order.getOrderDetails()){
            od.setOrder(order);
            od.setTongtien(od.getSoluong()*order.getGiathucte());
//            Product sp = productRepostory.findById(od.getProduct().getId()).get();
//            od.setProduct(sp);
            orderDetailRepostory.save(od);
        }
        OrderStatus os = orderStatusRepostory.findById(1).get();
        order.setOrderStatus(os);
        orderRepostory.save(order);
        return "Dat hang thanh cong !";
    }

    public List<Order> HienThiDSDonHang(int id_user){
        List<Order> lst = new ArrayList<>();
        for (Order od: orderRepostory.findAll()){
            if (od.getUserId()==id_user){
                lst.add(od);
            }
        }
        return lst;
    }



}
