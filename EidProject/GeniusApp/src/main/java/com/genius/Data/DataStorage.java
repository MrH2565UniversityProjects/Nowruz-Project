package com.genius.Data;

import com.genius.Entities.Identity.*;
import com.genius.Entities.Music.*;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private List<User> users = new ArrayList<>();
    private List<Artist> artists = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private List<FollowingArtists> followingArtists = new ArrayList<>();
    private List<Album> albums = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<CommentReaction> commentReactions = new ArrayList<>();
    private List<EditLyricsSuggest> editLyricsSuggests = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }


    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<FollowingArtists> getFollowingArtists() {
        return followingArtists;
    }

    public void setFollowingArtists(List<FollowingArtists> followingArtists) {
        this.followingArtists = followingArtists;
    }


    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<CommentReaction> getCommentReactions() {
        return commentReactions;
    }

    public void setCommentReactions(List<CommentReaction> commentReactions) {
        this.commentReactions = commentReactions;
    }


    public List<EditLyricsSuggest> getEditLyricsSuggests() {
        return editLyricsSuggests;
    }

    public void setEditLyricsSuggests(List<EditLyricsSuggest> editLyricsSuggests) {
        this.editLyricsSuggests = editLyricsSuggests;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
