package com.app.msplayer.mapper;

import com.app.msplayer.dto.PlaylistDTO;
import com.app.msplayer.entity.Playlist;
import org.springframework.stereotype.Component;

@Component
public class PlaylistMapper {
    // Mapping cho Playlist
    public static Playlist toEntity(PlaylistDTO playlistDTO) {
        return Playlist.builder()
                .name(playlistDTO.getName())
                .build();
    }

    public static PlaylistDTO toDTO(Playlist playlist) {
        return new PlaylistDTO(playlist.getName(), playlist.getId());
    }
}
