package com.app.auth.controller;

import com.app.auth.dto.RegisterUser;
import com.app.auth.dto.SaveUser;
import com.app.auth.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisterUser> register(@RequestBody @Valid SaveUser newUser) {
        RegisterUser registerUser = authenticationService.registerCustomer(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUser);
    }
}
