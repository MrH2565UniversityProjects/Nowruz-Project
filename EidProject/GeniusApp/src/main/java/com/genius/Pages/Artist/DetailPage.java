package com.genius.Pages.Artist;

import com.AP.Cli.InputHandler;
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
        var Artist = unitOfWork.getArtistService().GetById(id);
        System.out.println(Artist);
        InputHandler.WaitForKey("Press enter for back...");
        Router.getInstance().goBack();
    }
}