package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.User;
import com.example.repositories.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<Void> signup(@RequestBody MultiValueMap<String, String> params) {
        String account = params.getFirst("username");
        String password = params.getFirst("password");
        String confirmed = params.getFirst("confirmed");
        
        // ... 检查是否已经注册、非空、二次输入正确、密码强度等
        
        User user = new User();
        user.setAccount(account);
        user.setEncodedPassword(passwordEncoder.encode(password));
        repository.save(user);
        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
