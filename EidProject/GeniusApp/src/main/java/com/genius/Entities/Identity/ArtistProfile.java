package com.genius.Entities.Identity;

public class ArtistProfile {
    private String bio;

    public ArtistProfile(String bio) {
        this.bio = bio;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
}