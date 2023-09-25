//package com.example.api_banhang.sevices.impl;
//
//import com.example.api_banhang.dto.ClientSdi;
//import com.example.api_banhang.dto.DataMailDTO;
//import com.example.api_banhang.sevices.ClientService;
//import com.example.api_banhang.sevices.MailService;
//import com.example.api_banhang.until.Const;
//import com.example.api_banhang.until.DataUtils;
//import jakarta.mail.MessagingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class ClientServiceImpl implements ClientService {
//    @Autowired
//    private MailService mailService;
//
//    @Override
//    public Boolean create(ClientSdi sdi) {
//        try {
//            DataMailDTO dataMail = new DataMailDTO();
//
//            dataMail.setTo(sdi.getEmail());
//            dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);
//
//            Map<String, Object> props = new HashMap<>();
//            props.put("name", sdi.getName());
//            props.put("username", sdi.getUsername());
//            props.put("password", DataUtils.generateTemPwd(6));
//            dataMail.setProps(props);
//
//            mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
//            return true;
//        } catch (MessagingException exp){
//            exp.printStackTrace();
//        }
//        return false;
//    }
//
//
//}