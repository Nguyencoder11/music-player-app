/*
 * AuthorApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import com.app.msplayer.dto.request.LoginRequest;
import com.app.msplayer.dto.request.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AuthorApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/auth")
public interface AuthorApi {
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginRequest request);

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody RegisterRequest request);

    @PostMapping("/logout")
    ResponseEntity<Void> logout();

    @PostMapping("/refresh-token")


}
