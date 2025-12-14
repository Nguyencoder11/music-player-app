/*
 * SongApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.*;

/**
 * SongApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/songs")
public interface SongApi {
    @GetMapping("/get-alls")

    @GetMapping("/{songId}/detail")

    @PostMapping("/new-song")

    @PutMapping("/{songId}/update")

    @DeleteMapping("/{songId}")

    @GetMapping("/{songId}/stream")

}
