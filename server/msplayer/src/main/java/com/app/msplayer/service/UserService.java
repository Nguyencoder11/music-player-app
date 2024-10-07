package com.app.msplayer.service;

import com.app.msplayer.dto.UserDTO;
import com.app.msplayer.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO userDto);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, UserDTO userDto);
    void deleteUser(Long id);
}
