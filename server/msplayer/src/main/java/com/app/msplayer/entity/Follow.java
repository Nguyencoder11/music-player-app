/*
 * Follow.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.entity;

import com.app.msplayer.enums.FollowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Follow.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "follows")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Follow {
    @Id
    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @Id
    @Column(name = "followed_id", nullable = false)
    private Long followedId;

    @Enumerated(EnumType.STRING)
    @Column(name = "follow_type", nullable = false)
    private FollowType followType;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
