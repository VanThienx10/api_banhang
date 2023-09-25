package com.example.api_banhang.config;

import com.example.api_banhang.model.Role;
import com.example.api_banhang.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDungData {
    private User nguoiDung;
    private List<Role> quyenList;
}
