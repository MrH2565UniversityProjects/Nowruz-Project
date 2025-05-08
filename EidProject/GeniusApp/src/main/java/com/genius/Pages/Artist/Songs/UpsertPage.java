package com.genius.Pages.Artist.Songs;

import com.AP.Cli.FormHandler;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Music.Song;
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
    public boolean ShouldSaveInHistory(){
        return false;
    }
    @Override
    protected void ShowContent(Object[] param) {
           String id = RouteParameterHelper.getParameter(param,0,String.class,null);
           String albumId = RouteParameterHelper.getParameter(param,1,String.class,null);
           Song song = new Song();
           if(id != null){
               song = unitOfWork.getSongService().GetById(id);
               if(song == null){
                   System.out.println("404 not found");
                   Router.getInstance().navigate("Artist/Songs",albumId);
                   return;
               }
               var album = unitOfWork.getAlbumService().GetById(song.getAlbumId());
               if(!Objects.equals(album.getUserId(), Session.getInstance().getCurrentAccount().getId())){
                   System.out.println("You don't have access to this Song");
                   Router.getInstance().navigate("Artist/Songs",albumId);
                   return;
               }
               albumId = song.getAlbumId();
               FormHandler.collectData(song,true);
               unitOfWork.getSongService().Edit(song);
           }
           else
           {
               FormHandler.collectData(song);
               song.setUserId(Session.getInstance().getCurrentAccount().getId());
               song.setAlbumId(albumId);
               unitOfWork.getSongService().Add(song);
           }
           Router.getInstance().navigate("Artist/Songs",albumId);
    }
}