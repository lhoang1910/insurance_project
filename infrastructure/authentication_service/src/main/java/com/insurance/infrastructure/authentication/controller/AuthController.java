package com.insurance.infrastructure.authentication.controller;

import com.insurance.infrastructure.authentication.service.AuthService;
import com.insurance.infrastructure.shared.request.user.CreateUserRequest;
import com.insurance.infrastructure.shared.request.user.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request, @RequestHeader(value = "loggedInUser", defaultValue = "annoymous") String loggedInUser) {
        return ResponseEntity.ok(authService.createUser(request, loggedInUser));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
