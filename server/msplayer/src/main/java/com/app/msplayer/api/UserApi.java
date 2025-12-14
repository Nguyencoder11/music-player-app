/*
 * UserApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.*;

/**
 * UserApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/users")
public interface UserApi {
    @GetMapping("/{userId}/profile")

    @PutMapping("/{userId}/profile/update")

    @DeleteMapping("/{userId}")

    @PostMapping("/upgrade-to-premium")

    @PostMapping("/verify-artist")

    @PostMapping("/roles/assign")

    @GetMapping("/{userId}/preferences")

    @PostMapping("/{userId}/preferences")

    @PutMapping("/{userId}/preferences/{genreId}")

    @GetMapping("/{userId}/history")

    @GetMapping("/{userId}/likes")

    @GetMapping("/{userId}/followers")

    @GetMapping("/{userId}/following")
}
