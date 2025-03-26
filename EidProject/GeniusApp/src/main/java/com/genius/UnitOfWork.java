package com.genius;

import com.genius.Data.DataStorage;

public class UnitOfWork {
    private DataStorage dataStorage = null;
    public DataStorage GetDataStorage() {
        if (dataStorage == null) {
            dataStorage = new DataStorage();
        }
        return dataStorage;
    }
}
