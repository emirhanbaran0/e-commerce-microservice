package com.emirhan.baran.user_ms.controller;

import com.emirhan.baran.user_ms.dto.UserProfileDto;
import com.emirhan.baran.user_ms.dto.UserRegisterDto;
import com.emirhan.baran.user_ms.entity.User;
import com.emirhan.baran.user_ms.service.UserService;
import com.emirhan.baran.user_ms.util.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("profile/{id}")
    public GenericResponse getUserProfile(@PathVariable("id") Long id) {
        UserProfileDto user=userService.getByUserId(id);
        if(user==null){
            return new GenericResponse(404,"User not found with specified id: "+id,null);
        }else {
            return new GenericResponse(200,"User found with specified id: "+id,user);
        }
    }

    @PostMapping("/register")
    public GenericResponse getUserProfile(@RequestBody UserRegisterDto userRegisterDto) {
        boolean result=userService.saveUser(userRegisterDto);
        if(result){
            return new GenericResponse(201,"User registered successfully",null);
        }else {
            return new GenericResponse(500,"Error while saving user ",null);
        }
    }


}
