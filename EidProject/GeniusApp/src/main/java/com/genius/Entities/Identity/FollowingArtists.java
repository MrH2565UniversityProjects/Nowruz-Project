package com.genius.Entities.Identity;

import com.AP.EntityBase;

public class FollowingArtists extends EntityBase {
    private String userId;
    private String artistId;

    public FollowingArtists(){

    }
    public FollowingArtists(String userId,String artistId){
        this.artistId = artistId;
        this.userId = userId;
    }
    public String getArtistId(){
        return artistId;
    }
    public String getUserId(){
        return userId;
    }
    public void setArtistId(String ArtistId){
        artistId = ArtistId;
    }
    public void setUserId(String UserId){
        userId = UserId;
    }
}