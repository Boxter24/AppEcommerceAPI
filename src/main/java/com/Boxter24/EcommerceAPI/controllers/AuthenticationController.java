package com.Boxter24.EcommerceAPI.controllers;

import com.Boxter24.EcommerceAPI.auth.AuthenticationRequest;
import com.Boxter24.EcommerceAPI.auth.AuthenticationResponse;
import com.Boxter24.EcommerceAPI.auth.RegisterRequest;
import com.Boxter24.EcommerceAPI.models.User;
import com.Boxter24.EcommerceAPI.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ecommerce/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}

