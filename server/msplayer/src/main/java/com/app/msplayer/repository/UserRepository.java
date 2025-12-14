/*
 * UserRepository.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.app.msplayer.repository;

import com.app.msplayer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository.java
 *
 * @author Nguyen
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
