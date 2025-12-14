/*
 * Album.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import com.app.msplayer.enums.AlbumStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Album.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "released_date")
    private LocalDate releasedDate;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    @Column(name = "total_tracks")
    private int totalTracks = 0;

    @Column(name = "total_duration")
    private int totalDuration = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AlbumStatus status = AlbumStatus.PUBLISHED;

    @OneToMany(mappedBy = "album")
    private Set<AlbumSong> albumSongs = new HashSet<>();

    @OneToMany(mappedBy = "entityId")
    private Set<Like> likes = new HashSet<>();
}
