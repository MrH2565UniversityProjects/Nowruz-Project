package com.genius.Services;

import com.genius.Entities.BaseEntity;


import java.util.List;
import java.util.function.Predicate;
public interface IService<T extends BaseEntity> {
    public void Add(T model);
    public void Edit(T model);
    public void Delete(String id);
    public T GetById(String id);
    public List<T> GetAll();
    public List<T> GetAll(Predicate<T> predicate);
}
