package com.genius.Services;

import com.AP.EntityBase;


import java.util.List;

public interface ISearchableService<T extends EntityBase> {
    public List<T> GetByQuery(String query);
}
