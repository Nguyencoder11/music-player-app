/*
 * AlbumApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.*;

/**
 * AlbumApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/albums")
public interface AlbumApi {
    @GetMapping("/get-alls")

    @GetMapping("/{albumId}/detail")

    @PostMapping("/new-album")

    @PutMapping("/{albumId}/update")

    @DeleteMapping("/{albumId}")
}
