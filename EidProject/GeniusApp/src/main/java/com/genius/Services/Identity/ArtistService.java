package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.Account;
import com.genius.Entities.Identity.Artist;
import com.genius.Entities.Identity.ArtistProfile;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArtistService{

    private final DataStorage dataStorage;

    public ArtistService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }
    public void Add(Artist model) {
        Account account = model.getAccount();
        account.addRole("Artist");
        account.setArtistProfile(new ArtistProfile(
                model.getBio()
        ));
        dataStorage.Accounts.add(account);
    }
    public void Edit(Artist model) {
        for (Account acc : dataStorage.Accounts) {
            if (acc.getId().equals(model.getId())) {
                acc.setName(model.getName());
                if (acc.getArtistProfile() != null) {
                    acc.getArtistProfile().setBio(model.getBio());
                }
                return;
            }
        }
    }
    public void Delete(String id) {
        for (Account acc : dataStorage.Accounts) {
            if (acc.getId().equals(id)) {
                acc.setArtistProfile(null);
                acc.getRoles().remove("Artist");
                return;
            }
        }
    }
    public Artist GetById(String id) {
        return dataStorage.Accounts.stream()
                .filter(acc -> acc.getRoles().contains("Artist") &&
                        acc.getId().equals(id) &&
                        acc.getArtistProfile() != null)
                .map(Artist::new)
                .findFirst()
                .orElse(null);
    }
    public List<Artist> GetAll() {
        return dataStorage.Accounts.stream()
                .filter(acc -> acc.getRoles().contains("Artist") &&
                        acc.getArtistProfile() != null)
                .map(Artist::new)
                .collect(Collectors.toList());
    }
    public List<Artist> GetAll(Predicate<Artist> predicate) {
        return GetAll().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
    public List<Artist> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return GetAll();
        }
        return GetAll().stream()
                .filter(artist -> artist.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
