package com.genius.Services.Music;

import com.genius.Data.DataStorage;
import com.genius.Entities.Music.CommentReaction;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class CommentReactionService implements IService<CommentReaction> {

    DataStorage dataStorage;

    public CommentReactionService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(CommentReaction model) {
        dataStorage.CommentReactions.add(model);
    }

    @Override
    public void Edit(CommentReaction model) {
        for (int i = 0; i < dataStorage.CommentReactions.size(); i++) {
            if (dataStorage.CommentReactions.get(i).getId().equals(model.getId())) {
                dataStorage.CommentReactions.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.CommentReactions.removeIf(CommentReaction -> CommentReaction.getId().equals(id));
    }

    @Override
    public CommentReaction GetById(String id) {
        return dataStorage.CommentReactions.stream()
                .filter(CommentReaction -> CommentReaction.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CommentReaction> GetAll() {
        return dataStorage.CommentReactions;
    }
    @Override
    public List<CommentReaction> GetAll(Predicate<CommentReaction> predicate) {
        return GetAll().stream().filter(predicate).toList();
    }

}
