/*
 * Playlist.java
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
import java.util.HashSet;
import java.util.Set;

/**
 * Playlist.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "playists")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private Long playlistId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    @Column(name = "is_public")
    private boolean isPublic = false;

    @Column(name = "is_collaborative")
    private boolean isCollaborative = false;

    @Column(name = "total_tracks")
    private int totalTracks = 0;

    @Column(name = "total_duration")
    private int totalDuration = 0;

    @Column(name = "follower_count")
    private long followerCount = 0;

    @Column(name = "like_count")
    private long likeCount = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    @OneToMany(mappedBy = "playlist")
    private Set<PlaylistSong> playlistSongs = new HashSet<>();

    @OneToMany(mappedBy = "entityId")
    private Set<Like> likes = new HashSet<>();
}
