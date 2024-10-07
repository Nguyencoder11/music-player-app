package com.app.msplayer.service;

import com.app.msplayer.dto.PlaylistDTO;
import com.app.msplayer.entity.Playlist;
import com.app.msplayer.entity.User;
import com.app.msplayer.exception.ResourceNotFoundException;
import com.app.msplayer.repository.PlaylistRepository;
import com.app.msplayer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Playlist createPlaylist(PlaylistDTO playlistDTO) {
        User user = userRepository.findById(playlistDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + playlistDTO.getUserId()));
        Playlist playlist = new Playlist();
        playlist.setName(playlistDTO.getName());
        playlist.setUser(user);
        playlist.setCreatedAt(LocalDateTime.now());
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist updatePlaylist(Long id, PlaylistDTO playlistDTO) {
        Playlist playlist = getPlaylistById(id);
        playlist.setName(playlistDTO.getName());
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist getPlaylistById(Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id: " + id));
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public void deletePlaylist(Long id) {
        Playlist playlist = getPlaylistById(id);
        playlistRepository.delete(playlist);
    }
}
