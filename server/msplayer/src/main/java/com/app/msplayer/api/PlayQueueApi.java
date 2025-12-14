/*
 * PlayQueueApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PlayQueueApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/play-queue")
public interface PlayQueueApi {
    @GetMapping("/get-play")

    @PostMapping("/add-into-queue")

    @DeleteMapping("/{queueId}")

}
