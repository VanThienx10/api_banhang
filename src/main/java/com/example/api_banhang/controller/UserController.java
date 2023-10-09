package com.example.api_banhang.controller;

import com.example.api_banhang.auth.AuthRequest;
import com.example.api_banhang.auth.JwtService;
import com.example.api_banhang.config.NguoiDungData;
import com.example.api_banhang.model.User;

import com.example.api_banhang.model.UserRole;
import com.example.api_banhang.sevices.UserSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserSevices userSevices;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }
    @PostMapping(value = "authentication/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @PostMapping(value = "user/dangky")
    public String AddUser(@RequestBody(required = false) User user){
        return userSevices.addUser(user);
    }

    @PutMapping(value = "/user/sua")
    public String SuaUser(@RequestBody User user){
        return userSevices.SuaUser(user);
    }
    @PutMapping(value = "/user/phanquyen")
    public String SuaQuyen(@RequestBody UserRole userRole){
        return userSevices.PhanQuyen(userRole);
    }
    @PostMapping(value = "user/themphanquyen")
    public String ThemPhanQuyen(@RequestBody UserRole userRole){
        return userSevices.ThemPhanQuyen(userRole);
    }

    @GetMapping(value = "/api/admin/getuser")
    public List<User> getUser(){
        return userSevices.getAllUser();
    }

    @DeleteMapping(value ="/api/admin/xoauser" )
    public String XoaUser(@RequestParam int user_id){
        return userSevices.XoaUser(user_id);
    }
}
