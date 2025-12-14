/*
 * AlbumRepository.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.repository;

import com.app.msplayer.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AlbumRepository.java
 *
 * @author Nguyen
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
