/*
 * ModeratorApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ModeratorApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/moderation")
public interface ModeratorApi {
    @PutMapping("/songs/{songId}")

    @PutMapping("/users/{userId}")


}
