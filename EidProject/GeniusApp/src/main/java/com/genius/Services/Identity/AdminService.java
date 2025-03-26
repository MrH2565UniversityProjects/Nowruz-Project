package com.genius.Services.Identity;

import com.genius.Data.DataStorage;
import com.genius.Entities.Identity.Admin;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class AdminService implements IService<Admin>, ISearchableService<Admin> {

    DataStorage dataStorage;

    public AdminService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(Admin model) {
        dataStorage.Admins.add(model);
    }

    @Override
    public void Edit(Admin model) {
        for (int i = 0; i < dataStorage.Admins.size(); i++) {
            if (dataStorage.Admins.get(i).getId().equals(model.getId())) {
                dataStorage.Admins.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Admins.removeIf(Admin -> Admin.getId().equals(id));
    }

    @Override
    public Admin GetById(String id) {
        return dataStorage.Admins.stream()
                .filter(Admin -> Admin.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Admin> GetAll() {
        return dataStorage.Admins;
    }
    @Override
    public List<Admin> GetAll(Predicate<Admin> predicate) {
        return GetAll().stream().filter(predicate).toList();
    }
    @Override
    public List<Admin> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return dataStorage.Admins;
        }
        return GetAll(Admin -> Admin.getName().toLowerCase().contains(query.toLowerCase()));
    }
}
