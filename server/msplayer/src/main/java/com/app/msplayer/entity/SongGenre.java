/*
 * SongGenre.java
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
 * SongGenre.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "song_genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongGenre {
    @Id
    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Id
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
