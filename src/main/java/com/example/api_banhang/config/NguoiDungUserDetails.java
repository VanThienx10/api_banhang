package com.example.api_banhang.config;

import com.example.api_banhang.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NguoiDungUserDetails implements UserDetails {
    private String email;
    private String password;
    private List<GrantedAuthority> authorities;

    public NguoiDungUserDetails(NguoiDungData nguoiDung) {
        email = nguoiDung.getNguoiDung().getEmail();
        password = nguoiDung.getNguoiDung().getPassword();
        String[] roleList = new String[nguoiDung.getQuyenList().size()];
        int i = 0;
        for (Role role : nguoiDung.getQuyenList()) {
            roleList[i] = role.getName();
            i++;
        }
        authorities = Arrays.stream(roleList)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
