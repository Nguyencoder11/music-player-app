/*
 * Artist.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import com.app.msplayer.enums.ArtistStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Artist.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long artistId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "bio")
    private String bio;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    @Column(name = "website_url")
    private String websiteUrl;

    @Column(name = "country")
    private String country;

    @Column(name = "follower_count")
    private long followerCount = 0;

    @Column(name = "like_count")
    private long likeCount = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ArtistStatus status = ArtistStatus.ACTIVE;

    @OneToMany(mappedBy = "artist")
    private Set<Album> albums = new HashSet<>();

    @OneToMany(mappedBy = "artist")
    private Set<SongArtist> songArtists = new HashSet<>();
}
