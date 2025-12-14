/*
 * ListeningHistory.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ListeningHistory.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "listening_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListeningHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(name = "listened_at", nullable = false)
    private LocalDateTime listenedAt = LocalDateTime.now();

    @Column(name = "duration_listened")
    private Integer durationListened;
}
