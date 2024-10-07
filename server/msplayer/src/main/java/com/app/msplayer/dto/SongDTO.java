package com.app.msplayer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String artist;

    @NotBlank
    private String album;

    @NotBlank
    private String filePath;

    private String albumImage;
}
