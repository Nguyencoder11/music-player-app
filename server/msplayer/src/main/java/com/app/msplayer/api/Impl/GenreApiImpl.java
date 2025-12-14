package com.app.msplayer.api.Impl;

import com.app.msplayer.api.GenreApi;
import com.app.msplayer.dto.GenreDTO;
import com.app.msplayer.entity.Genre;
import com.app.msplayer.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin()  (khi cau hinh CORS thi k can annotation nay)
@RestController
@RequiredArgsConstructor
public class GenreApiImpl implements GenreApi {
    private final GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody GenreDTO genreDto) {
        return ResponseEntity.ok(genreService.createGenre(genreDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody GenreDTO genreDto) {
        return ResponseEntity.ok(genreService.updateGenre(id, genreDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
