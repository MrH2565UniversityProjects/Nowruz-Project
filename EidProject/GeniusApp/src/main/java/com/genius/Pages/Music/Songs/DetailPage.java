package com.genius.Pages.Music.Songs;

import com.AP.Cli.Menu;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.genius.UnitOfWork;

public class DetailPage extends Page {
    private final UnitOfWork unitOfWork;
    public DetailPage(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Detail Page");
    }

    @Override
    protected void ShowContent(Object[] param) {
        String id = RouteParameterHelper.getParameter(param,0,String.class,null);
        var song = unitOfWork.getSongService().GetById(id);
        System.out.println(song);
        Menu SongOption = new Menu();
        SongOption.addOption("Comments",options -> {
            Router.getInstance().navigate("Songs/Comments", id);
        });
        SongOption.addOption("Suggest Lyrics",options -> {
            Router.getInstance().navigate("Songs/SuggestLyrics", id);
        });
        SongOption.navigateMenu("Song Options");
    }
}