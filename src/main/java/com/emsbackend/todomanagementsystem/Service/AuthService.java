package com.emsbackend.todomanagementsystem.Service;

import com.emsbackend.todomanagementsystem.DTO.JwtAuthResponse;
import com.emsbackend.todomanagementsystem.DTO.LoginDto;
import com.emsbackend.todomanagementsystem.DTO.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);
}
