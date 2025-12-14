/*
 * ArtistApi.java
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
 * ArtistApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/artists")
public interface ArtistApi {
    @GetMapping("/{artistId}/artist-profile")

    @PutMapping("/{artistId}/artist-profile/update")

    @GetMapping("/{artistId}/albums")

    @GetMapping("/{artistId}/songs")

    @PostMapping("/create-profile")

    @PutMapping("/{artistId}/verify")
}
