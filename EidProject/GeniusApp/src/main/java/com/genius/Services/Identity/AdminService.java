package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.Admin;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AdminService implements IService<Admin>, ISearchableService<Admin> {

    private final DataStorage dataStorage;

    public AdminService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(Admin model) {
        dataStorage.Accounts.add(model);
    }

    @Override
    public void Edit(Admin model) {
        for (int i = 0; i < dataStorage.Accounts.size(); i++) {
            if (dataStorage.Accounts.get(i) instanceof Admin &&
                    dataStorage.Accounts.get(i).getUsername().equals(model.getUsername())) {
                dataStorage.Accounts.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Accounts.removeIf(account -> account instanceof Admin && account.getUsername().equals(id));
    }

    @Override
    public Admin GetById(String id) {
        return dataStorage.Accounts.stream()
                .filter(account -> account instanceof Admin && account.getUsername().equals(id))
                .map(account -> (Admin)account)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Admin> GetAll() {
        return dataStorage.Accounts.stream()
                .filter(account -> account instanceof Admin)
                .map(account -> (Admin) account)
                .collect(Collectors.toList());
    }

    @Override
    public List<Admin> GetAll(Predicate<Admin> predicate) {
        return GetAll().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Admin> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return GetAll();
        }
        return GetAll(Admin -> Admin.getName().toLowerCase().contains(query.toLowerCase()));
    }
}
