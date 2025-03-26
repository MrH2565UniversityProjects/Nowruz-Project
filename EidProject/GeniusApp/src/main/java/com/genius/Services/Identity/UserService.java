package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.User;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class UserService implements IService<User>, ISearchableService<User> {

    DataStorage dataStorage;

    public UserService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(User model) {
        dataStorage.Users.add(model);
    }

    @Override
    public void Edit(User model) {
        for (int i = 0; i < dataStorage.Users.size(); i++) {
            if (dataStorage.Users.get(i).getId().equals(model.getId())) {
                dataStorage.Users.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Users.removeIf(User -> User.getId().equals(id));
    }

    @Override
    public User GetById(String id) {
        return dataStorage.Users.stream()
                .filter(User -> User.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> GetAll() {
        return dataStorage.Users;
    }

    @Override
    public List<User> GetAll(Predicate<User> predicate) {
        return GetAll().stream().filter(predicate).toList();
    }

    @Override
    public List<User> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return dataStorage.Users;
        }
        return GetAll(User -> User.getName().toLowerCase().contains(query.toLowerCase()));
    }
}
