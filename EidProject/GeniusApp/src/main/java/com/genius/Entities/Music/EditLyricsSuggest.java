package com.genius.Entities.Music;

import com.AP.Annotations.UserInput;
import com.AP.EntityBase;
import com.genius.Enums.EditLyricsSuggestStatus;

public class EditLyricsSuggest extends EntityBase {
    private String userId;
    private String songId;
    @UserInput(label = "Enter your suggested lyrics", required = true)
    private String lyrics;
    private EditLyricsSuggestStatus editLyricsSuggestStatus;


    public EditLyricsSuggest() {
        this.editLyricsSuggestStatus = EditLyricsSuggestStatus.PENDING;
    }
    public EditLyricsSuggest(String userId, String songId, String lyrics, EditLyricsSuggestStatus editLyricsSuggestStatus) {
        super();
        this.userId = userId;
        this.songId = songId;
        this.lyrics = lyrics;
        this.editLyricsSuggestStatus = editLyricsSuggestStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public EditLyricsSuggestStatus getEditLyricsSuggestStatus() {
        return editLyricsSuggestStatus;
    }

    public void setEditLyricsSuggestStatus(EditLyricsSuggestStatus editLyricsSuggestStatus) {
        this.editLyricsSuggestStatus = editLyricsSuggestStatus;
    }
}
