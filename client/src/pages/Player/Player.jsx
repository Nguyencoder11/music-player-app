import axios from 'axios';
import React, { useEffect, useState } from 'react'

const Player = () => {
    const [songs, setSongs] = useState([]);
    const [currentSong, setCurrentSong] = useState(null)

    useEffect(() => {
        const fetchSongs = async () => {
            try {
                const response = await axios.get('http://localhost:9192/api/songs');
                setSongs(response.data);
            } catch (error) {
                console.error("Failed to fetch songs", error);
            }
        };

        fetchSongs();
    }, []);

    const playSong = (song) => {
        setCurrentSong(song);
        // Logic phát nhạc (sử dụng HTML5 Audio hoặc thư viện phát nhạc khác)
    }
    return (
        <div>
            <h2>Music Player</h2>
            <div>
                <h3>Now Playing: {currentSong ? currentSong.title : 'No song selected'}</h3>
                <div>
                    <button onClick={() => {/* Logic de play/pause bai hat */}}>Play/Pause</button>
                    <button onClick={() => {/* Logic de chuyen bai */}}>Next</button>
                </div>
            </div>
            <ul>
                {songs.map((song) =>(
                    <li key={song.id} onClick={() => playSong(song)}>
                        {song.title} - {song.artist}
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default Player
