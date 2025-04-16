package com.genius.Entities.Music;

import com.AP.Annotations.UserInput;
import com.AP.EntityBase;

import java.time.LocalDateTime;
import java.util.List;

public class Album extends EntityBase {
    private String userId;
    @UserInput(label = "Enter the album title", required = true)
    private String title;
    @UserInput(label = "Enter Album release date", required = true)
    private LocalDateTime releaseDate;
    private List<Song> trackList;

    public Album(){

    }
    public Album(String userId,String title, LocalDateTime releaseDate) {
        super();
        this.userId = userId;
        this.title = title;
        this.releaseDate = releaseDate;

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
    @Override
    public String toString() {
        return "Album{" +
                "id='" + getId() + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", trackCount=" + (trackList != null ? trackList.size() : 0) +
                '}';
    }

}