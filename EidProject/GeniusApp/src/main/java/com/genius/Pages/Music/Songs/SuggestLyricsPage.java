package com.genius.Pages.Music.Songs;

import com.AP.Cli.FormHandler;
import com.AP.Cli.Menu;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Music.EditLyricsSuggest;
import com.genius.Entities.Music.Song;
import com.genius.UnitOfWork;

import java.util.List;
import java.util.Objects;

public class SuggestLyricsPage extends Page {
    private final UnitOfWork unitOfWork;
    public SuggestLyricsPage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Songs Page");
    }
    @Override
    public boolean ShouldSaveInHistory() {
        return false;
    }
    @Override
    protected void ShowContent(Object[] param) {
        String id = RouteParameterHelper.getParameter(param,0,String.class,null);
        var editLyricsSuggest = new EditLyricsSuggest();
        FormHandler.collectData(editLyricsSuggest);
        editLyricsSuggest.setSongId(id);
        editLyricsSuggest.setUserId(Session.getInstance().getCurrentAccount().getId());
        unitOfWork.getEditLyricsSuggestService().Add(editLyricsSuggest);
        Router.getInstance().navigate("Songs");
    }


}