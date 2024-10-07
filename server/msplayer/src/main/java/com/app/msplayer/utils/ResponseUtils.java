package com.app.msplayer.utils;

import org.springframework.http.ResponseEntity;

public class ResponseUtils {
    public static <T>ResponseEntity<T> success(T data) {
        return ResponseEntity.ok(data);
    }

    public static ResponseEntity<String> error(String message) {
        return ResponseEntity.badRequest().body(message);
    }
}
