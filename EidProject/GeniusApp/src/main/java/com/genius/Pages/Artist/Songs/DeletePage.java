package com.genius.Pages.Artist.Songs;

import com.AP.Cli.InputHandler;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.genius.Entities.Music.Song;
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
    public boolean ShouldSaveInHistory(){
        return false;
    }
    @Override
    protected void ShowContent(Object[] param) {
        String id = RouteParameterHelper.getParameter(param,0,String.class,null);
        Song song = new Song();
        if(id != null){
            song = unitOfWork.getSongService().GetById(id);
            boolean isDelete = InputHandler.getYesNo("Do you want delete this "+ song.toString());
            if(isDelete)
                unitOfWork.getSongService().Delete(id);
        }
        Router.getInstance().navigate("Artist/Songs");
    }
}