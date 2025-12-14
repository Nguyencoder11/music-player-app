package com.app.msplayer.api.Impl;

import com.app.msplayer.api.UserApi;
import com.app.msplayer.dto.UserDTO;
import com.app.msplayer.entity.User;
import com.app.msplayer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin()    (khi cau hinh CORS thi k can annotation nay)
@RestController
@RequiredArgsConstructor    // tu dong tao constructor cho tat ca cac bien final
public class UserApiImpl implements UserApi {
    // su dung annotation RequiredArgsConstructor
    // khi khai bao final cho userService
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
