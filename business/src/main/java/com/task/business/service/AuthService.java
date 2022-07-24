package com.task.business.service;

import com.task.business.dto.JwtAuthentication;
import com.task.business.dto.JwtRequest;
import com.task.business.dto.JwtResponse;
import lombok.NonNull;

public interface AuthService {

    JwtResponse login(@NonNull JwtRequest authRequest);

    JwtResponse getAccessToken(@NonNull String refreshToken);

    JwtResponse refresh(@NonNull String refreshToken);

    JwtAuthentication getAuthInfo();
}
