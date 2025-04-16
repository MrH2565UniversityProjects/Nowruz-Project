package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.User;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserService implements IService<User>, ISearchableService<User> {

    private final DataStorage dataStorage;

    public UserService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(User model) {
        dataStorage.Accounts.add(model);
    }

    @Override
    public void Edit(User model) {
        for (int i = 0; i < dataStorage.Accounts.size(); i++) {
            if (dataStorage.Accounts.get(i) instanceof User &&
                    dataStorage.Accounts.get(i).getUsername().equals(model.getUsername())) {
                dataStorage.Accounts.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Accounts.removeIf(account -> account instanceof User && account.getUsername().equals(id));
    }

    @Override
    public User GetById(String id) {
        return dataStorage.Accounts.stream()
                .filter(account -> account instanceof User && account.getUsername().equals(id))
                .map(account -> (User)account)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> GetAll() {
        return dataStorage.Accounts.stream()
                .filter(account -> account instanceof User)
                .map(account -> (User) account)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> GetAll(Predicate<User> predicate) {
        return GetAll().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<User> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return GetAll();
        }
        return GetAll(User -> User.getName().toLowerCase().contains(query.toLowerCase()));
    }
}
