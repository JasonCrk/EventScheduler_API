package com.LP2.EventScheduler.controller;

import com.LP2.EventScheduler.dto.auth.LoginDTO;
import com.LP2.EventScheduler.dto.auth.RegisterDTO;
import com.LP2.EventScheduler.model.User;
import com.LP2.EventScheduler.response.MessageResponse;
import com.LP2.EventScheduler.response.auth.JwtResponse;
import com.LP2.EventScheduler.response.user.SimpleUserResponse;
import com.LP2.EventScheduler.service.auth.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping(path = "/user")
    public ResponseEntity<SimpleUserResponse> retrieveUserByToken(
            @RequestAttribute("user") User authUser
    ) {
        return ResponseEntity.ok(this.authService.retrieveUserByToken(authUser));
    }

    @GetMapping(path = "/verify")
    public ResponseEntity<MessageResponse> verifyToken(
            HttpServletRequest request
    ) {
        return ResponseEntity.ok(this.authService.verifyToken(request));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<JwtResponse> login(
            @Valid @RequestBody LoginDTO loginData
    ) {
        return new ResponseEntity<>(this.authService.login(loginData), HttpStatus.OK);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<JwtResponse> register(
            @Valid @RequestBody RegisterDTO registerData
    ) {
        return new ResponseEntity<>(this.authService.register(registerData), HttpStatus.CREATED);
    }

    @PostMapping(path = "/refresh-token")
    public ResponseEntity<JwtResponse> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return new ResponseEntity<>(
                this.authService.refreshToken(request, response),
                HttpStatus.OK
        );
    }
}
