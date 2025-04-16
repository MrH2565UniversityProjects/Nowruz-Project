package com.genius.Entities.Music;

import com.AP.Annotations.UserInput;
import com.AP.EntityBase;
import com.genius.Enums.Reaction;

public class CommentReaction extends EntityBase {
    private String commentId;
    private String userId;
    @UserInput(label = "Enter your reaction", required = true)
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
