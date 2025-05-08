package com.genius.Data;

import com.AP.Cli.InputHandler;
import com.genius.Entities.Identity.*;
import com.genius.Entities.Music.*;
import com.genius.Enums.EditLyricsSuggestStatus;
import com.genius.Enums.Reaction;
import com.genius.Utils.HashUtil;

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
        Account admin = new Account("1", "Admin", 30, "admin@genius.com", "admin", HashUtil.hashPassword("admin", "1"));
        admin.setArtistProfile(new ArtistProfile("I am Admin"));
        admin.setIsVerified(true);
        admin.addRole("Admin");
        admin.addRole("Artist");
        admin.addRole("User");

        Account artist1 = new Account("4", "Artist1", 30, "artist1@genius.com", "artist1", HashUtil.hashPassword("12345678", "4"));
        artist1.setIsVerified(true);
        artist1.addRole("Artist");

        Account user1 = new Account("2", "User1", 30, "user1@genius.com", "User1", HashUtil.hashPassword("12345678", "2"));
        user1.setIsVerified(true);
        user1.addRole("User");

        Account user2 = new Account("3", "User3", 20, "user2@genius.com", "User2", HashUtil.hashPassword("12345678", "3"));
        user2.setIsVerified(true);
        user2.addRole("User");

        dataStorage.Accounts.add(admin);
        dataStorage.Accounts.add(user1);
        dataStorage.Accounts.add(user2);
        dataStorage.Accounts.add(artist1);

        Album album1 = new Album("1", "Album1", LocalDateTime.now().minusDays(30));
        Album album2 = new Album("1", "Album2", LocalDateTime.now().minusDays(20));
        Album album3 = new Album("1", "Album3", LocalDateTime.now().minusDays(50));
        Album album4 = new Album("4", "Album4", LocalDateTime.now().minusDays(50));
        dataStorage.Albums.add(album1);
        dataStorage.Albums.add(album2);
        dataStorage.Albums.add(album3);
        dataStorage.Albums.add(album4);
        Song song1 = new Song(album1.getId(),"Song1","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",LocalDateTime.now());
        dataStorage.Songs.add(song1);
        Song song2 = new Song(album1.getId(),"Song2","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",LocalDateTime.now());
        dataStorage.Songs.add(song2);
        Song song3 = new Song(album4.getId(),"Song3","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",LocalDateTime.now());
        dataStorage.Songs.add(song3);
        Comment comment1 = new Comment(user1.getId(),song1.getId(),"Comment1 Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo");
        dataStorage.Comments.add(comment1);
        CommentReaction commentReaction1 = new CommentReaction(comment1.getId(),user2.getId(),Reaction.LIKE);
        dataStorage.CommentReactions.add(commentReaction1);
        CommentReaction commentReaction2 = new CommentReaction(comment1.getId(),user1.getId(),Reaction.LIKE);
        dataStorage.CommentReactions.add(commentReaction2);
        Comment comment2 = new Comment(user2.getId(),song3.getId(),"Comment1 Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo");
        dataStorage.Comments.add(comment2);

        EditLyricsSuggest suggest1 = new EditLyricsSuggest(user1.getId(),song1.getId(),"1000" + song1.getLyrics(), EditLyricsSuggestStatus.PENDING);
        dataStorage.EditLyricsSuggests.add(suggest1);
        EditLyricsSuggest suggest2 = new EditLyricsSuggest(user1.getId(),song1.getId(),"1001" + song1.getLyrics(), EditLyricsSuggestStatus.PENDING);
        dataStorage.EditLyricsSuggests.add(suggest2);
        EditLyricsSuggest suggest3 = new EditLyricsSuggest(user1.getId(),song1.getId(),"1002" + song1.getLyrics(), EditLyricsSuggestStatus.PENDING);
        dataStorage.EditLyricsSuggests.add(suggest3);
    }
}
