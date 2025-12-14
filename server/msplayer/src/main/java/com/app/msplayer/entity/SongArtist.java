/*
 * SongArtist.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import com.app.msplayer.enums.ArtistRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * SongArtist.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "song_artist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongArtist {
    @Id
    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

    @Id
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ArtistRole role = ArtistRole.MAIN;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
