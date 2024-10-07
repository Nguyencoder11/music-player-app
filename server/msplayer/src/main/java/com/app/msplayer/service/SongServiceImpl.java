package com.app.msplayer.service;

import com.app.msplayer.dto.SongDTO;
import com.app.msplayer.entity.Song;
import com.app.msplayer.exception.ResourceNotFoundException;
import com.app.msplayer.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    private SongRepository songRepository;

    @Override
    public Song createSong(SongDTO songDto) {
        Song song = new Song();
        song.setTitle(songDto.getTitle());
        song.setArtist(songDto.getArtist());
        song.setAlbum(songDto.getAlbum());
        song.setFilePath(songDto.getFilePath());
        song.setAlbumImage(songDto.getAlbumImage());
        song.setCreatedAt(LocalDateTime.now());
        return songRepository.save(song);
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id: " + id));
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song updateSong(Long id, SongDTO songDto) {
        Song song = getSongById(id);
        song.setTitle(songDto.getTitle());
        song.setArtist(songDto.getArtist());
        song.setAlbum(songDto.getAlbum());
        song.setFilePath(songDto.getFilePath());
        song.setAlbumImage(songDto.getAlbumImage());
        return songRepository.save(song);
    }

    @Override
    public void deleteSong(Long id) {
        Song song = getSongById(id);
        songRepository.delete(song);
    }
}
