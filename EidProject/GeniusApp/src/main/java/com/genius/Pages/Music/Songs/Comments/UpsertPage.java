package com.genius.Pages.Music.Songs.Comments;

import com.AP.Cli.FormHandler;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Music.Comment;
import com.genius.UnitOfWork;

import java.util.Objects;

public class UpsertPage extends Page {
    private final UnitOfWork unitOfWork;
    public UpsertPage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("UpsertPage");
    }

    @Override
    protected void ShowContent(Object[] param) {
           String id = RouteParameterHelper.getParameter(param,0,String.class,null);
           Comment Comment = new Comment();
           if(id != null){
               if(!Objects.equals(Comment.getUserId(), Session.getInstance().getCurrentAccount().getId())){
                   System.out.println("You don't have access to this Comment");
                   Router.getInstance().navigate("Songs");
                   return;
               }
               Comment = unitOfWork.getCommentService().GetById(id);

               FormHandler.collectData(Comment,true);
               unitOfWork.getCommentService().Edit(Comment);
           }
           else
           {
               FormHandler.collectData(Comment);
               Comment.setUserId(Session.getInstance().getCurrentAccount().getId());
               unitOfWork.getCommentService().Add(Comment);
           }
           Router.getInstance().navigate("Songs",Comment.getSongId());
    }
}