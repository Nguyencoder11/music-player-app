/*
 * AdminApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/admin")
public interface AdminApi {
    @GetMapping("/all-users")

    @GetMapping("/users")

    @GetMapping("/transactions")

    @PostMapping("/transactions/add")

}
