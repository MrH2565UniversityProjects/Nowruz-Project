package com.genius.Entities.Music;

import com.genius.Entities.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Album extends BaseEntity {
    private String userId;
    private String title;
    private LocalDateTime releaseDate;
    private List<Song> trackList;

    public Album(){

    }
    public Album(String userId,String title, LocalDateTime releaseDate, List<Song> trackList) {
        super();
        this.userId = userId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trackList = trackList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Song> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Song> trackList) {
        this.trackList = trackList;
    }
}