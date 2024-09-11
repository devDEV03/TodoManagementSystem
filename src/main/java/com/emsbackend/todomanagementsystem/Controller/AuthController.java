package com.emsbackend.todomanagementsystem.Controller;


import com.emsbackend.todomanagementsystem.DTO.JwtAuthResponse;
import com.emsbackend.todomanagementsystem.DTO.LoginDto;
import com.emsbackend.todomanagementsystem.DTO.RegisterDto;
import com.emsbackend.todomanagementsystem.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {


    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        JwtAuthResponse jwtAuthResponse = authService.login(loginDto);
        return new ResponseEntity<>(jwtAuthResponse,HttpStatus.CREATED);
    }
}
