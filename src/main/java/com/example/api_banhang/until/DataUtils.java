package com.example.api_banhang.until;

import java.util.Random;

public class DataUtils {
    public static String  generateTemPwd(int lengt){
        String numbers = "012345678";
        char otp[]  =new char[lengt];
        Random getOptNum = new Random();

        for (int i=0;i<lengt;i++){
            otp[i] = numbers.charAt(getOptNum.nextInt(numbers.length()));
        }

        String optVode = "";
        for (int i=0;i< otp.length;i++){
            optVode+=otp[i];
        }
        return optVode;
    }
}
