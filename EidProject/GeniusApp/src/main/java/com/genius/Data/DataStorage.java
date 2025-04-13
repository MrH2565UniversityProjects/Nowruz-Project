package com.genius.Data;

import com.genius.Entities.Identity.*;
import com.genius.Entities.Music.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    public List<Account> Accounts = new ArrayList<>();
    public List<FollowingArtists> FollowingArtists = new ArrayList<>();
    public List<Album> Albums = new ArrayList<>();
    public List<Comment> Comments = new ArrayList<>();
    public List<CommentReaction> CommentReactions = new ArrayList<>();
    public List<EditLyricsSuggest> EditLyricsSuggests = new ArrayList<>();
    public List<Song> Songs = new ArrayList<>();
    public DataStorage(){
        Seed(this);
    }
    private static void Seed(DataStorage dataStorage){
        dataStorage.Albums.add(new Album("1","Tamasha", LocalDateTime.now()));
    }
}
