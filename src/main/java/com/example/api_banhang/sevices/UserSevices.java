package com.example.api_banhang.sevices;

import com.example.api_banhang.model.Role;
import com.example.api_banhang.model.User;
import com.example.api_banhang.model.UserRole;
import com.example.api_banhang.repostory.RoleRepostory;
import com.example.api_banhang.repostory.UserRepostory;
import com.example.api_banhang.repostory.UserRoleRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSevices {
    @Autowired
    private UserRepostory userRepostory;
    @Autowired
    private RoleRepostory roleRepostory;
    @Autowired
    private UserRoleRepostory userRoleRepostory;

    public String addUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepostory.save(user);
        Role r = roleRepostory.findById(2).get();
        UserRole ur = new UserRole();
        ur.setUser(user);
        ur.setRole(r);
        userRepostory.save(user);
        userRoleRepostory.save(ur);
        return "Them thanh cong! ";
    }

    public String SuaUser(User user){
        Optional<User> u = userRepostory.findById(user.getId());
        if (u.isEmpty()){
            return "User k ton tai";
        }else {
            User userCurrent = u.get();
            userCurrent =user;
            for (UserRole ur: userRoleRepostory.findAll()){
                if (ur.getUser().getId()==user.getId()){
                    ur.setRole(roleRepostory.findById(1).get());
                    userRoleRepostory.save(ur);
                }
            }

            userRepostory.save(userCurrent);
            return "Sua thnah cong!";
        }
    }
    public String SuaPhanQuyen(UserRole userRole){
        Optional<UserRole> ur=  userRoleRepostory.findById(userRole.getId());
        if (ur.isEmpty()){
            return "Khong ton tai quyen";
        }else {
            UserRole urCurrent = ur.get();
            urCurrent = userRole;
            userRoleRepostory.save(urCurrent);
            return "Sua thanh cong !";

        }
    }

    public List<User> getAllUser(){
        return  userRepostory.findAll();
    }
}
