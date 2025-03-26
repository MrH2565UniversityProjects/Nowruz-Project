package com.genius.Data;

import com.genius.Entities.Identity.*;
import com.genius.Entities.Music.*;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    public List<User> Users = new ArrayList<>();
    public List<Artist> Artists = new ArrayList<>();
    public List<Admin> Admins = new ArrayList<>();
    public List<FollowingArtists> FollowingArtists = new ArrayList<>();
    public List<Album> Albums = new ArrayList<>();
    public List<Comment> Comments = new ArrayList<>();
    public List<CommentReaction> CommentReactions = new ArrayList<>();
    public List<EditLyricsSuggest> EditLyricsSuggests = new ArrayList<>();
    public List<Song> Songs = new ArrayList<>();


}
