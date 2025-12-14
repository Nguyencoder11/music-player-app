/*
 * LoginRequest.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.dto.request;

import lombok.Data;

/**
 * LoginRequest.java
 *
 * @author Nguyen
 */
@Data
public class LoginRequest {
    private String email;
    private String password;
}
