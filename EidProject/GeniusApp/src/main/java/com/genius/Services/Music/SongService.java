package com.genius.Services.Music;

import com.genius.Data.DataStorage;
import com.genius.Entities.Music.Song;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class SongService implements IService<Song>, ISearchableService<Song> {

    DataStorage dataStorage;

    public SongService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(Song model) {
        dataStorage.Songs.add(model);
    }

    @Override
    public void Edit(Song model) {
        for (int i = 0; i < dataStorage.Songs.size(); i++) {
            if (dataStorage.Songs.get(i).getId().equals(model.getId())) {
                dataStorage.Songs.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Songs.removeIf(Song -> Song.getId().equals(id));
    }

    @Override
    public Song GetById(String id) {
        return dataStorage.Songs.stream()
                .filter(Song -> Song.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Song> GetAll() {
        return dataStorage.Songs;
    }
    @Override
    public List<Song> GetAll(Predicate<Song> predicate) {
        return GetAll().stream().filter(predicate).toList();
    }
    @Override
    public List<Song> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return dataStorage.Songs;
        }
        return GetAll(Song -> Song.getTitle().toLowerCase().contains(query.toLowerCase()));
    }
}
