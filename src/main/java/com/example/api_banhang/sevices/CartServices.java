package com.example.api_banhang.sevices;

import com.example.api_banhang.model.Cart;
import com.example.api_banhang.model.CartItem;
import com.example.api_banhang.model.User;
import com.example.api_banhang.repostory.CartItemRepostory;
import com.example.api_banhang.repostory.CartRepostory;
import com.example.api_banhang.repostory.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServices {
    @Autowired
    private CartRepostory cartRepostory;
    @Autowired
    private CartItemRepostory cartItemRepostory;
    @Autowired
    private UserRepostory userRepostory;

    public String ThemGioHang(Cart cart){
        cartRepostory.save(cart);
        for (CartItem ci: cart.getCartItems()){
            cartItemRepostory.save(ci);
        }
        return "Them thanh cong !";
    }
}
