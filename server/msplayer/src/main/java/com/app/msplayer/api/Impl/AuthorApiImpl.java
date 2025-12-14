/*
 * AuthorApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api.Impl;

import com.app.msplayer.api.AuthorApi;
import com.app.msplayer.dto.request.LoginRequest;
import com.app.msplayer.dto.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthorApi.java
 *
 * @author Nguyen
 */
@RestController
@RequiredArgsConstructor
public class AuthorApiImpl implements AuthorApi {
    @Override
    public ResponseEntity<?> login(LoginRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> register(RegisterRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> logout() {
        return null;
    }
}
