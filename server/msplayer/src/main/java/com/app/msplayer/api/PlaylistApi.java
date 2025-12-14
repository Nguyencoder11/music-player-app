/*
 * PlaylistApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.*;

/**
 * PlaylistApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/playlists")
public interface PlaylistApi {
    @GetMapping("/get-alls")

    @GetMapping("/{playlistId}/detail")

    @PostMapping("/new-playlist")

    @PutMapping("/{playlistId}/update")

    @DeleteMapping("/{playlistId}")

    @PostMapping("/{playlistId}/songs/add-song")

    @DeleteMapping("/{playlistId}/songs/{songId}")
}
