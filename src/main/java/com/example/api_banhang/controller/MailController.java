//package com.example.api_banhang.controller;
//
//import com.example.api_banhang.dto.ClientSdi;
//import com.example.api_banhang.sevices.ClientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MailController {
//    @Autowired
//    private ClientService clientService;
//
//    @PostMapping(value = "/client")
//    public ResponseEntity<Boolean> create(@RequestBody ClientSdi sdi){
//        return ResponseEntity.ok(clientService.create(sdi));
//    }
//
//}
