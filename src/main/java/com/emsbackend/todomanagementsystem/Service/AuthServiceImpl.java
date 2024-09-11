package com.emsbackend.todomanagementsystem.Service;


import com.emsbackend.todomanagementsystem.DTO.JwtAuthResponse;
import com.emsbackend.todomanagementsystem.DTO.LoginDto;
import com.emsbackend.todomanagementsystem.DTO.RegisterDto;
import com.emsbackend.todomanagementsystem.Entity.Role;
import com.emsbackend.todomanagementsystem.Entity.User;
import com.emsbackend.todomanagementsystem.Exception.TodoAPIException;
import com.emsbackend.todomanagementsystem.Repository.RoleRepository;
import com.emsbackend.todomanagementsystem.Repository.UserRepository;
import com.emsbackend.todomanagementsystem.config.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

  private UserRepository userRepository;

  private RoleRepository roleRepository;

  private PasswordEncoder passwordEncoder;

  private AuthenticationManager authenticationManager;
  private JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterDto registerDto) {

        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Username already exist");
        }

        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Email  already exists");
        }

        User user =new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roleSet = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roleSet.add(userRole);

        user.setRoles(roleSet);

        userRepository.save(user);
        return "User Registered Successfully! ";
    }

    @Override
    public JwtAuthResponse login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);


        Optional<User> userOptional =  userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail());

        String role = null;
        if(userOptional.isPresent()){
            User loggedInUser = userOptional.get();
            Optional<Role>  optionalRole = loggedInUser.getRoles().stream().findFirst();

            if (optionalRole.isPresent()){
                Role userRole = optionalRole.get();
            }

        }

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setRole(role);
        jwtAuthResponse.setAccessToken(token);

        return jwtAuthResponse;
    }
}
