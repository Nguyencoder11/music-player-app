package com.app.msplayer.mapper;

import com.app.msplayer.dto.GenreDTO;
import com.app.msplayer.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    // Mapping cho Genre
    public static Genre toEntity(GenreDTO genreDTO) {
        return Genre.builder()
                .name(genreDTO.getName())
                .build();
    }

    public static GenreDTO toDTO(Genre genre) {
        return new GenreDTO(genre.getName());
    }
}
