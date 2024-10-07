package com.app.msplayer.service;

import com.app.msplayer.dto.PlaylistDTO;
import com.app.msplayer.entity.Playlist;

import java.util.List;

public interface PlaylistService {
    Playlist createPlaylist(PlaylistDTO playlistDTO);
    Playlist updatePlaylist(Long id, PlaylistDTO playlistDTO);
    Playlist getPlaylistById(Long id);
    List<Playlist> getAllPlaylists();
    void deletePlaylist(Long id);
}
