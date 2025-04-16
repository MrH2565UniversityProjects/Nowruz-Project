package com.genius.Services.Music;

import com.genius.Data.DataStorage;
import com.genius.Entities.Music.EditLyricsSuggest;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class EditLyricsSuggestService implements IService<EditLyricsSuggest> {

    DataStorage dataStorage;

    public EditLyricsSuggestService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(EditLyricsSuggest model) {
        dataStorage.EditLyricsSuggests.add(model);
    }

    @Override
    public void Edit(EditLyricsSuggest model) {
        for (int i = 0; i < dataStorage.EditLyricsSuggests.size(); i++) {
            if (dataStorage.EditLyricsSuggests.get(i).getId().equals(model.getId())) {
                dataStorage.EditLyricsSuggests.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.EditLyricsSuggests.removeIf(EditLyricsSuggest -> EditLyricsSuggest.getId().equals(id));
    }

    @Override
    public EditLyricsSuggest GetById(String id) {
        return dataStorage.EditLyricsSuggests.stream()
                .filter(EditLyricsSuggest -> EditLyricsSuggest.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<EditLyricsSuggest> GetAll() {
        return dataStorage.EditLyricsSuggests;
    }
    @Override
    public List<EditLyricsSuggest> GetAll(Predicate<EditLyricsSuggest> predicate) {
        return GetAll().stream().filter(predicate).toList();
    }

}
