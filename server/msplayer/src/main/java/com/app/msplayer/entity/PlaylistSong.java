/*
 * PlaylistSong.java
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
 * PlaylistSong.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "playlist_songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistSong {
    @Id
    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = false)
    private Playlist playlist;

    @Id
    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Column(name = "position", nullable = false)
    private int position;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
