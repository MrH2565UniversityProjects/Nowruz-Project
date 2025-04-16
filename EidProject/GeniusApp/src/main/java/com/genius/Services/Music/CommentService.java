package com.genius.Services.Music;

import com.genius.Data.DataStorage;
import com.genius.Entities.Music.Comment;
import com.genius.Services.*;

import java.util.List;
import java.util.function.Predicate;


public class CommentService implements IService<Comment>, ISearchableService<Comment> {

    DataStorage dataStorage;

    public CommentService(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void Add(Comment model) {
        dataStorage.Comments.add(model);
    }

    @Override
    public void Edit(Comment model) {
        for (int i = 0; i < dataStorage.Comments.size(); i++) {
            if (dataStorage.Comments.get(i).getId().equals(model.getId())) {
                dataStorage.Comments.set(i, model);
                return;
            }
        }
    }

    @Override
    public void Delete(String id) {
        dataStorage.Comments.removeIf(Comment -> Comment.getId().equals(id));
    }

    @Override
    public Comment GetById(String id) {
        return dataStorage.Comments.stream()
                .filter(Comment -> Comment.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Comment> GetAll() {
        return dataStorage.Comments;
    }
    @Override
    public List<Comment> GetAll(Predicate<Comment> predicate) {
        return GetAll().stream().filter(predicate).toList();
    }
    @Override
    public List<Comment> GetByQuery(String query) {
        if (query == null || query.isEmpty()) {
            return dataStorage.Comments;
        }
        return GetAll(Comment -> Comment.getContent().toLowerCase().contains(query.toLowerCase()));
    }
}
