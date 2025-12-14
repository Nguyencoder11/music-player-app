/*
 * ListeningHistoryApi.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ListeningHistoryApi.java
 *
 * @author Nguyen
 */
@RequestMapping("/api/listening-history")
public interface ListeningHistoryApi {
    @PostMapping
}
