package com.app.msplayer.service;

import com.app.msplayer.dto.SongDTO;
import com.app.msplayer.entity.Song;

import java.util.List;

public interface SongService {
    Song createSong(SongDTO songDto);
    Song getSongById(Long id);
    List<Song> getAllSongs();
    Song updateSong(Long id, SongDTO songDto);
    void deleteSong(Long id);
}
