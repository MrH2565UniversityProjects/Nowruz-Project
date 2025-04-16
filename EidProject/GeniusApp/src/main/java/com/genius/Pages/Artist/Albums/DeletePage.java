package com.genius.Pages.Artist.Albums;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.AP.Cli.FormHandler;
import com.AP.Cli.InputHandler;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Music.Album;
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
        Album album = new Album();
        if(id != null){
            album = unitOfWork.getAlbumService().GetById(id);
            boolean isDelete = InputHandler.getYesNo("Do you want delete this "+ album.toString());
            if(isDelete)
                unitOfWork.getAlbumService().Delete(id);
        }
        Router.getInstance().navigate("Albums");
    }
}