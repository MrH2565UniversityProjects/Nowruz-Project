package com.genius;

import com.genius.Data.DataStorage;
import com.genius.Services.Identity.*;
import com.genius.Services.Music.*;


public class UnitOfWork {
    private DataStorage dataStorage = null;

    public DataStorage getDataStorage() {
        if (dataStorage == null) {
            dataStorage = new DataStorage();
        }
        return dataStorage;
    }

    private AccountManager accountManager = null;
    private AdminService adminService = null;
    private UserService userService = null;
    private ArtistService artistService = null;
    private AlbumService albumService = null;
    private SongService songService = null;
    private CommentService commentService = null;
    private CommentReactionService commentReactionService = null;
    private EditLyricsSuggestService editLyricsSuggestService = null;
    private FollowingArtistsService followingArtistsService = null;


    public AdminService getAdminService() {
        if (adminService == null) {
            adminService = new AdminService(getDataStorage());
        }
        return adminService;
    }
    public AccountManager getAccountManager() {
        if (accountManager == null) {
            accountManager = new AccountManager(getDataStorage());
        }
        return accountManager;
    }

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserService(getDataStorage());
        }
        return userService;
    }

    public ArtistService getArtistService() {
        if (artistService == null) {
            artistService = new ArtistService(getDataStorage());
        }
        return artistService;
    }


    public AlbumService getAlbumService() {
        if (albumService == null) {
            albumService = new AlbumService(getDataStorage());
        }
        return albumService;
    }


    public SongService getSongService() {
        if (songService == null) {
            songService = new SongService(getDataStorage());
        }
        return songService;
    }


    public CommentService getCommentService() {
        if (commentService == null) {
            commentService = new CommentService(getDataStorage());
        }
        return commentService;
    }


    public CommentReactionService getCommentReactionService() {
        if (commentReactionService == null) {
            commentReactionService = new CommentReactionService(getDataStorage());
        }
        return commentReactionService;
    }


    public EditLyricsSuggestService getEditLyricsSuggestService() {
        if (editLyricsSuggestService == null) {
            editLyricsSuggestService = new EditLyricsSuggestService(getDataStorage());
        }
        return editLyricsSuggestService;
    }


    public FollowingArtistsService getFollowingArtistsService() {
        if (followingArtistsService == null) {
            followingArtistsService = new FollowingArtistsService(getDataStorage());
        }
        return followingArtistsService;
    }
}
