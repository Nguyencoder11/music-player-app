/*
 * NotificationApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * NotificationApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/notifications")
public interface NotificationApi {
    @GetMapping("/list")

    @PutMapping("/{notificationId}/mark")

    @PostMapping("/create")
}
