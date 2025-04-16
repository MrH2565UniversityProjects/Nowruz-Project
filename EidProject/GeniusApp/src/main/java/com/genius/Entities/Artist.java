package com.genius.Entities.Identity;

public class Artist {
    private final Account account;

    public Artist(Account account) {
        if (account == null || !account.getRoles().contains("Artist") || account.getArtistProfile() == null) {
            throw new IllegalArgumentException("Account is not a valid artist.");
        }
        this.account = account;
    }

    public String getId() {
        return account.getId();
    }

    public String getName() {
        return account.getName();
    }

    public String getEmail() {
        return account.getEmail();
    }

    public int getAge() {
        return account.getAge();
    }

    public boolean isVerified() {
        return account.getIsVerified();
    }


    public String getBio() {
        return account.getArtistProfile().getBio();
    }

    public void setBio(String label) {
        account.getArtistProfile().setBio(label);
    }

    public Account getAccount() {
        return account;
    }
}
