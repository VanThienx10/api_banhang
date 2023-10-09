package com.example.api_banhang.config;


import com.example.api_banhang.model.Role;
import com.example.api_banhang.model.User;
import com.example.api_banhang.repostory.RoleRepostory;
import com.example.api_banhang.repostory.UserRepostory;
import com.example.api_banhang.repostory.UserRoleRepostory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepostory _nguoiDungRepo;
    @Autowired
    private RoleRepostory _quyenRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> nguoiDung = _nguoiDungRepo.findByEmailEquals(email.toLowerCase());
        List<Role> quyen = _quyenRepo.getAllQuyen(nguoiDung.get().getId());
           NguoiDungData nguoiDungData = new NguoiDungData(nguoiDung.get(),quyen);
           Optional<NguoiDungData> optCheck = Optional.of(nguoiDungData);
        return optCheck.map(NguoiDungUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Không tồn tại người dùng có email là: " + email));
    }


    
}
