package com.app.msplayer.mapper;

import com.app.msplayer.dto.SongDTO;
import com.app.msplayer.entity.Song;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {
    // Mapping cho Song
    public static Song toEntity(SongDTO songDto) {
        return Song.builder()
                .title(songDto.getTitle())
                .artist(songDto.getArtist())
                .album(songDto.getAlbum())
                .filePath(songDto.getFilePath())
                .albumImage(songDto.getAlbumImage())
                .build();
    }

    public static SongDTO toDto(Song song) {
        return new SongDTO(song.getTitle(), song.getArtist(), song.getAlbum(), song.getFilePath(), song.getAlbumImage());
    }
}
