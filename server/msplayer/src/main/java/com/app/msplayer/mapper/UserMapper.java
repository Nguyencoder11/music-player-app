package com.app.msplayer.mapper;

import com.app.msplayer.dto.UserDTO;
import com.app.msplayer.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Mapping cho User
    public static User toEntity(UserDTO userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build();
    }

    public static UserDTO toDto(User user) {
        return new UserDTO(user.getUsername(), user.getPassword(), user.getEmail());
    }
}
