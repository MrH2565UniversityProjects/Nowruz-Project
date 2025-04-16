package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.FollowingArtists;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class FollowingArtistsService implements IService<FollowingArtists> {

    DataStorage dataStorage;

    public FollowingArtistsService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(FollowingArtists model) {
        dataStorage.FollowingArtists.add(model);
    }

    @Override
    public void Edit(FollowingArtists model) {
        for (int i = 0; i < dataStorage.FollowingArtists.size(); i++) {
            if (dataStorage.FollowingArtists.get(i).getId().equals(model.getId())) {
                dataStorage.FollowingArtists.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.FollowingArtists.removeIf(FollowingArtists -> FollowingArtists.getId().equals(id));
    }

    @Override
    public FollowingArtists GetById(String id) {
        return dataStorage.FollowingArtists.stream()
                .filter(FollowingArtists -> FollowingArtists.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<FollowingArtists> GetAll() {
        return dataStorage.FollowingArtists;
    }
    @Override
    public List<FollowingArtists> GetAll(Predicate<FollowingArtists> predicate) {
        return GetAll().stream().filter(predicate).toList();
    }
}
