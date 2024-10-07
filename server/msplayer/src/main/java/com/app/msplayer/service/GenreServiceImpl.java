package com.app.msplayer.service;

import com.app.msplayer.dto.GenreDTO;
import com.app.msplayer.entity.Genre;
import com.app.msplayer.exception.ResourceNotFoundException;
import com.app.msplayer.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre createGenre(GenreDTO genreDto) {
        Genre genre = new Genre();
        genre.setName(genreDto.getName());
        genre.setCreatedAt(LocalDateTime.now());
        return genreRepository.save(genre);
    }

    @Override
    public Genre updateGenre(Long id, GenreDTO genreDto) {
        Genre genre = getGenreById(id);
        genre.setName(genreDto.getName());
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id));
    }

    @Override
    public void deleteGenre(Long id) {
        Genre genre = getGenreById(id);
        genreRepository.delete(genre);
    }
}
