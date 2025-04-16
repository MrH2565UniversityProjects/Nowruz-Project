package com.genius.Pages.Music.Songs.Comments;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Music.Comment;
import com.genius.UnitOfWork;

import java.util.List;
import java.util.Objects;

public class IndexPage extends Page {
    private final UnitOfWork unitOfWork;
    public IndexPage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Index Page");
    }

    @Override
    protected void ShowContent(Object[] param) {
        List<Comment> Comments = unitOfWork.getCommentService().GetAll();
        Menu CommentList = new Menu();
        CommentList.addOption("Create",options -> {
            Router.getInstance().navigate("Songs/Comments/Upsert");
        });
        for (Comment Comment : Comments) {
            var CommentOptions = CreateCommentMoreOptionMenu(Comment);
            var user = unitOfWork.getAccountManager().GetAccountById(Comment.getUserId());
            String previewContent;
            if (Comment.getContent().length() > 15) {
                previewContent = Comment.getContent().substring(0, 15) + "...";
            }else{
                previewContent =  Comment.getContent();
            }
            CommentList.addOption(user.getName() + "-" + previewContent, option -> {
                if (Objects.equals(Session.getInstance().getCurrentAccount().getId(), Comment.getUserId())) {
                    CommentOptions.navigateMenu(user.getName() + "-" + Comment.getContent());
                } else {
                    Router.getInstance().navigate("Songs/Comments/Detail", Comment.getId());
                }
            });
        }
        CommentList.navigateMenu("Comment List");
    }

    private Menu CreateCommentMoreOptionMenu(Comment Comment) {
        var CommentOptions = new Menu();
            CommentOptions.addOption("Edit",options -> {
                Router.getInstance().navigate("Songs/Comments/Upsert", Comment.getId());
            });
            CommentOptions.addOption("Detail",options -> {
                Router.getInstance().navigate("Songs/Comments/Detail", Comment.getId());
            });
            CommentOptions.addOption("Delete",options -> {
                Router.getInstance().navigate("Songs/Comments/Delete", Comment.getId());
            });
        return CommentOptions;
    }
}