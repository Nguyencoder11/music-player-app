/*
 * User.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import com.app.msplayer.enums.ActiveStatus;
import com.app.msplayer.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * User.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "country")
    private String country;

    @Column(name = "language_preferences")
    private String languagePreferences;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "is_premium")
    private boolean isPremium = false;

    @Column(name = "premium_expiry")
    private LocalDateTime premiumExpiry;

    @Enumerated(EnumType.STRING)
    @Column(name = "active_status")
    private ActiveStatus activeStatus = ActiveStatus.ACTIVE;

    @OneToMany(mappedBy = "user")
    private Set<Artist> artists = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Playlist> playlists = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ListeningHistory> listeningHistories = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Like> likes = new HashSet<>();

    @OneToMany(mappedBy = "follower")
    private Set<Follow> follows = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Notification> notifications = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserPreference> preferences = new HashSet<>();


}
