/*
 * PlayQueue.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * PlayQueue.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "play_queue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "queue_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(name = "position", nullable = false)
    private int position;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
