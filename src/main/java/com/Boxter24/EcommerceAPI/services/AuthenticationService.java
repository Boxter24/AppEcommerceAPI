package com.Boxter24.EcommerceAPI.services;

import com.Boxter24.EcommerceAPI.auth.AuthenticationRequest;
import com.Boxter24.EcommerceAPI.auth.RegisterRequest;
import com.Boxter24.EcommerceAPI.config.JwtService;
import com.Boxter24.EcommerceAPI.models.Role;
import com.Boxter24.EcommerceAPI.models.User;
import com.Boxter24.EcommerceAPI.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(RegisterRequest request){
        Map<String,Object> response = new HashMap<>();

        var user = User.builder()
                .fullname(request.getFullname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        response.put("token", jwtToken);
        response.put("userActive", user);

        return new ResponseEntity<Map<String ,Object>>(response, OK);
    }

    public ResponseEntity<?> authenticate(AuthenticationRequest request){

        Map<String,Object> response = new HashMap<>();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        response.put("token", jwtToken);
        response.put("userActive", user);

        return new ResponseEntity<Map<String ,Object>>(response, OK);
    }

}
