package com.task.business.controller;

import com.task.business.dto.JwtRequest;
import com.task.business.dto.JwtResponse;
import com.task.business.dto.RefreshJwtRequest;
import com.task.business.dto.UserDto;
import com.task.business.service.AuthService;
import com.task.business.service.EmailSenderService;
import com.task.business.service.UserService;
import com.task.business.transformer.UserTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    private final EmailSenderService emailSenderService;

    private final UserTransformer userTransformer;

    @PostMapping("register")
    public ResponseEntity<JwtResponse> register(@Valid @RequestBody UserDto userDto) {
        userService.saveUser(userTransformer.transform(userDto));
        final JwtResponse token = authService.login(new JwtRequest(
                userDto.getLogin(), userDto.getPassword()
        ));
        emailSenderService.sendEmail(userDto.getEmail(),
                "Refresh Token for user" + userDto.getLogin(),
                "Refresh Token - " + token.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}