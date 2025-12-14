/*
 * Genre.java
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
 * Genre.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_genre_id")
    private Genre parentGenre;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "parentGenre")
    private Set<Genre> subGenres = new HashSet<>();

    @OneToMany(mappedBy = "genre")
    private Set<Album> albums = new HashSet<>();

    @OneToMany(mappedBy = "genre")
    private Set<SongGenre> songGenres = new HashSet<>();

    @OneToMany(mappedBy = "genre")
    private Set<UserPreference> userPreferences = new HashSet<>();
}
