package com.genius.Services.Music;

import com.genius.Data.DataStorage;
import com.genius.Entities.Music.Album;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class AlbumService implements IService<Album>, ISearchableService<Album> {

    DataStorage dataStorage;

    public AlbumService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(Album model) {
        dataStorage.Albums.add(model);
    }

    @Override
    public void Edit(Album model) {
        for (int i = 0; i < dataStorage.Albums.size(); i++) {
            if (dataStorage.Albums.get(i).getId().equals(model.getId())) {
                dataStorage.Albums.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Albums.removeIf(album -> album.getId().equals(id));
    }

    @Override
    public Album GetById(String id) {
        return dataStorage.Albums.stream()
                .filter(album -> album.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Album> GetAll() {
        return dataStorage.Albums;
    }
    @Override
    public List<Album> GetAll(Predicate<Album> predicate) {
       return GetAll().stream().filter(predicate).toList();
    }
    @Override
    public List<Album> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return dataStorage.Albums;
        }
        return GetAll(album -> album.getTitle().toLowerCase().contains(query.toLowerCase()));
    }
}
