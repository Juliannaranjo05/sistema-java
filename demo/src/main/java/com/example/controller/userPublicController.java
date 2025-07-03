package com.example.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.RequestLoginDTO;
import com.example.DTO.RequestRegisterDTO;
import com.example.DTO.ResponseLoginDTO;
import com.example.DTO.ResponsesDTO;
import com.example.DTO.userDTO;
import com.example.service.userService;

@RestController
@RequestMapping("api/v1/public/users")
public class userPublicController {
     @Autowired
    private userService userService;

   @PostMapping("/register")
    public ResponseEntity<Object> saveUser(@RequestBody RequestRegisterDTO user) {
        ResponsesDTO response = userService.save(user);
        // ResponsesDTO response =null;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login") //falta desarrollar
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody RequestLoginDTO userDTO) {
        ResponseLoginDTO response = userService.login(userDTO);
        // ResponseLogin response = null;
        return new ResponseEntity<ResponseLoginDTO>(response, HttpStatus.OK);
    }

    //  @PostMapping("/forgot") //falta desarrollar
    // public ResponseEntity<Object> forgot(@RequestBody UserDTO userDTO) {
    //     // ResponsesDTO response = userService.save(userDTO);
    //     return new ResponseEntity<>(response, HttpStatus.OK);
    // }
    
}
