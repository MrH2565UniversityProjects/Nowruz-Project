package com.genius.Entities;
import java.time.LocalDateTime;
import java.util.UUID;
public abstract class BaseEntity{
    private String id;
    private LocalDateTime createAt_;
    private LocalDateTime modifiedAt_;

    public BaseEntity(){
        id = UUID.randomUUID().toString();
        createAt_ = LocalDateTime.now();
        modifiedAt_ = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreateAt_() {
        return createAt_;
    }

    public LocalDateTime getModifiedAt_() {
        return modifiedAt_;
    }

    public void setModifiedAt_(LocalDateTime modifiedAt_) {
        this.modifiedAt_ = modifiedAt_;
    }
}