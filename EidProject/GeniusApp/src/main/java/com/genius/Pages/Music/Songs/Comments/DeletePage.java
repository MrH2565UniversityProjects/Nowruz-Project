package com.genius.Pages.Music.Songs.Comments;

import com.AP.Cli.InputHandler;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.genius.Entities.Music.Comment;
import com.genius.UnitOfWork;

public class DeletePage extends Page {
    private final UnitOfWork unitOfWork;
    public DeletePage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("DeletePage");
    }

    @Override
    protected void ShowContent(Object[] param) {
        String id = RouteParameterHelper.getParameter(param,0,String.class,null);
        Comment Comment = new Comment();
        if(id != null){
            Comment = unitOfWork.getCommentService().GetById(id);
            boolean isDelete = InputHandler.getYesNo("Do you want delete this "+ Comment.toString());
            if(isDelete)
                unitOfWork.getCommentService().Delete(id);
        }
        Router.getInstance().navigate("Songs");
    }
}