package com.app.msplayer.service;

import com.app.msplayer.dto.GenreDTO;
import com.app.msplayer.entity.Genre;

import java.util.List;

public interface GenreService {
    Genre createGenre(GenreDTO genreDto);
    Genre updateGenre(Long id, GenreDTO genreDto);
    List<Genre> getAllGenres();
    Genre getGenreById(Long id);
    void deleteGenre(Long id);
}
