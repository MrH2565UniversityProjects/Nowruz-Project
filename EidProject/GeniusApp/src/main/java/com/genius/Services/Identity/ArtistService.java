package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.Artist;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class ArtistService implements IService<Artist>, ISearchableService<Artist> {

    DataStorage dataStorage;

    public ArtistService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(Artist model) {
        dataStorage.Artists.add(model);
    }

    @Override
    public void Edit(Artist model) {
        for (int i = 0; i < dataStorage.Artists.size(); i++) {
            if (dataStorage.Artists.get(i).getId().equals(model.getId())) {
                dataStorage.Artists.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Artists.removeIf(Artist -> Artist.getId().equals(id));
    }

    @Override
    public Artist GetById(String id) {
        return dataStorage.Artists.stream()
                .filter(Artist -> Artist.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Artist> GetAll() {
        return dataStorage.Artists;
    }
    @Override
    public List<Artist> GetAll(Predicate<Artist> predicate) {
        return GetAll().stream().filter(predicate).toList();
    }
    @Override
    public List<Artist> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return dataStorage.Artists;
        }
        return GetAll(Artist -> Artist.getName().toLowerCase().contains(query.toLowerCase()));
    }
}
