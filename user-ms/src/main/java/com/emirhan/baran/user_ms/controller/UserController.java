package com.emirhan.baran.user_ms.controller;

import com.emirhan.baran.user_ms.dto.UserContactInfoDto;
import com.emirhan.baran.user_ms.dto.UserProfileDto;
import com.emirhan.baran.user_ms.dto.UserRegisterDto;
import com.emirhan.baran.user_ms.service.UserService;
import com.emirhan.baran.user_ms.util.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserContactInfoDto userContactInfoDto;
    @Value("${build.version}")
    private  String buildVersion;

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

    @Operation(summary = "Get contact info of User MS ")
    @ApiResponses( {
            @ApiResponse( responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/contact-info")
    public GenericResponse getContactInfo(){
        return new GenericResponse(200,"User MS contact info",userContactInfoDto);
    }

    @Operation(summary = "Get build info of User MS ")
    @ApiResponses( {
            @ApiResponse( responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/build-version")
    public GenericResponse getBuildInfo(){
        return new GenericResponse(200,"User MS build version",buildVersion);
    }



}
