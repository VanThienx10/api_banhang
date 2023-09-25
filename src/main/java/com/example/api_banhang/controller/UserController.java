package com.example.api_banhang.controller;

import com.example.api_banhang.model.User;

import com.example.api_banhang.model.UserRole;
import com.example.api_banhang.sevices.UserSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserSevices userSevices;


    @PostMapping(value = "user/dangky")
    public String AddUser(@RequestBody(required = false) User user){
        return userSevices.addUser(user);
    }

    @PutMapping(value = "/user/sua")
    public String SuaUser(@RequestBody User user){
        return userSevices.SuaUser(user);
    }
    @PutMapping(value = "/user/suaquyen")
    public String SuaQuyen(@RequestBody UserRole userRole){
        return userSevices.SuaPhanQuyen(userRole);
    }

    @GetMapping(value = "/api/admin/getuser")
    public List<User> getUser(){
        return userSevices.getAllUser();
    }
}
