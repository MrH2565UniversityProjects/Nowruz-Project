package com.genius.Entities.Music;

import com.genius.Entities.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Song extends BaseEntity {
    private String albumId;
    private String title;
    private String lyrics;
    private LocalDateTime releaseDate;
    private int viewsCount;

    public Song(){

    }
    public Song(String albumId,String title, String lyrics, LocalDateTime releaseDate) {
        super();
        this.albumId = albumId;
        this.title = title;
        this.lyrics = lyrics;
        this.releaseDate = releaseDate;
        this.viewsCount = 0;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void incrementViewsCount() {
        this.viewsCount++;
    }

}