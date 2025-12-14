/*
 * Song.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import com.app.msplayer.enums.SongStatus;
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
 * Song.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Long songId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "language")
    private String language;

    @Column(name = "bpm")
    private int bpm;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "stream_url", nullable = false)
    private String streamUrl;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    @Column(name = "is_explicit")
    private boolean isExplicit = false;

    @Column(name = "is_premium")
    private boolean isPremium = false;

    @Column(name = "listening_count")
    private long listeningCount = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "song_status")
    private SongStatus songStatus = SongStatus.PUBLISHED;

    @OneToMany(mappedBy = "song")
    private Set<SongArtist> songArtists = new HashSet<>();

    @OneToMany(mappedBy = "song")
    private Set<SongGenre> songGenres = new HashSet<>();

    @OneToMany(mappedBy = "song")
    private Set<AlbumSong> albumSongs = new HashSet<>();

    @OneToMany(mappedBy = "song")
    private Set<PlaylistSong> playlistSongs = new HashSet<>();

    @OneToMany(mappedBy = "song")
    private Set<ListeningHistory> listeningHistories = new HashSet<>();

    @OneToMany(mappedBy = "entityId")
    private Set<Like> likes = new HashSet<>();

    @OneToMany(mappedBy = "song")
    private Set<PlayQueue> playQueue = new HashSet<>();
}
