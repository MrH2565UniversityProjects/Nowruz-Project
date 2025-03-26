package com.genius.Entities.Music;

import com.genius.Entities.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Comment extends BaseEntity {
    private String userId;
    private String songId;
    private String content;

    public  Comment(){

    }

    public Comment(String userId,String songId, String content) {
        super();
        this.userId = userId;
        this.songId = songId;
        this.content = content;

    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}