/*
 * AlbumSong.java
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
 * AlbumSong.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "album_songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumSong {
    @Id
    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @Id
    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(name = "track_number", nullable = false)
    private int trackNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

}
