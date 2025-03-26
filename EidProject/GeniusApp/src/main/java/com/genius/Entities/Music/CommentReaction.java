package com.genius.Entities.Music;

import com.genius.Entities.BaseEntity;
import com.genius.Enums.Reaction;

public class CommentReaction extends BaseEntity {
    private String commentId;
    private String userId;
    private Reaction reaction;


    public CommentReaction() {
    }

    public CommentReaction(String commentId, String userId, Reaction reaction) {
        this.commentId = commentId;
        this.userId = userId;
        this.reaction = reaction;
    }


    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }
}
