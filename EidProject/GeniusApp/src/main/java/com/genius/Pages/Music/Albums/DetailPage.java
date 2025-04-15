package com.genius.Pages.Music.Albums;

import com.AP.Cli.Menu;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.genius.Entities.Music.Album;
import com.genius.UnitOfWork;

import java.util.List;

public class DetailPage extends Page {
    private final UnitOfWork unitOfWork;
    public DetailPage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Detail Page");
    }

    @Override
    protected void ShowContent(Object[] param) {
        String id = RouteParameterHelper.getParameter(param,0,String.class,null);
        var album = unitOfWork.getAlbumService().GetById(id);
        System.out.println(album);
    }
}