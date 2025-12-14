package com.app.msplayer.api.Impl;

import com.app.msplayer.api.SongApi;
import com.app.msplayer.dto.SongDTO;
import com.app.msplayer.entity.Song;
import com.app.msplayer.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin()    (khi cau hinh CORS thi k can annotation nay)
@RestController
@RequiredArgsConstructor
public class SongApiImpl implements SongApi {
    private final SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getSongById(id));
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody SongDTO songDto) {
        return ResponseEntity.ok(songService.createSong(songDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody SongDTO songDto) {
        return ResponseEntity.ok(songService.updateSong(id, songDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}
