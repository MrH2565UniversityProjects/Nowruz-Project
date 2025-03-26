package com.genius.Services;

import com.genius.Entities.BaseEntity;


import java.util.List;

public interface ISearchableService<T extends BaseEntity> {
    public List<T> GetByQuery(String query);
}
