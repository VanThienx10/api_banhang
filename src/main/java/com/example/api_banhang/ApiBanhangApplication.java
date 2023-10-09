package com.example.api_banhang;

//import com.example.api_banhang.mailsend.EmailMix;
import com.example.api_banhang.model.User;
import com.example.api_banhang.repostory.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiBanhangApplication {
//    final private User user = User.builder().username("van tu").email("tukoik@gmail.com").password("123456").build();

    public static void main(String[] args) {
//        EmailMix e = new EmailMix("nguyenthienx10@gmail.com","hery rhtf yfte wvti",1);
//        e.sendContentToVer2("anhdqph19418@fpt.edu.vn","hello","xin chao");
        SpringApplication.run(ApiBanhangApplication.class, args);
    }



}
