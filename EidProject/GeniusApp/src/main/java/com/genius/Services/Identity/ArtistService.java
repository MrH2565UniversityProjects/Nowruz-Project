package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.Artist;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArtistService implements IService<Artist>, ISearchableService<Artist> {

    private final DataStorage dataStorage;

    public ArtistService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(Artist model) {
        dataStorage.Accounts.add(model);
    }

    @Override
    public void Edit(Artist model) {
        for (int i = 0; i < dataStorage.Accounts.size(); i++) {
            if (dataStorage.Accounts.get(i) instanceof Artist &&
                    dataStorage.Accounts.get(i).getUsername().equals(model.getUsername())) {
                dataStorage.Accounts.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Accounts.removeIf(account -> account instanceof Artist && account.getUsername().equals(id));
    }

    @Override
    public Artist GetById(String id) {
        return dataStorage.Accounts.stream()
                .filter(account -> account instanceof Artist && account.getUsername().equals(id))
                .map(account -> (Artist)account)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Artist> GetAll() {
        return dataStorage.Accounts.stream()
                .filter(account -> account instanceof Artist)
                .map(account -> (Artist) account)
                .collect(Collectors.toList());
    }

    @Override
    public List<Artist> GetAll(Predicate<Artist> predicate) {
        return GetAll().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Artist> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return GetAll();
        }
        return GetAll(artist -> artist.getName().toLowerCase().contains(query.toLowerCase()));
    }
}
