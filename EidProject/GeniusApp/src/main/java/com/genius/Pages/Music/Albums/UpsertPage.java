package com.genius.Pages.Music.Albums;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.AP.Cli.FormHandler;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Music.Album;
import com.genius.UnitOfWork;

public class UpsertPage extends Page {
    private UnitOfWork unitOfWork;
    public UpsertPage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("UpsertPage");
    }

    @Override
    protected void ShowContent(Object[] param) {
        while (true) {
           String id = RouteParameterHelper.getParameter(param,0,String.class,null);
           Album album = new Album();
           if(id != null){
               album = unitOfWork.getAlbumService().GetById(id);
               FormHandler.collectData(album,true);
               unitOfWork.getAlbumService().Edit(album);
           }
           else
           {
               FormHandler.collectData(album);
               unitOfWork.getAlbumService().Add(album);
           }
        }
    }
}