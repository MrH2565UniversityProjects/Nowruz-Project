package com.genius.Pages.Music.Songs;

import com.AP.Cli.InputHandler;
import com.AP.Cli.Menu;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.genius.Entities.Music.Song;
import com.genius.UnitOfWork;

import java.util.List;
import java.util.Objects;

public class IndexPage extends Page {
    private final UnitOfWork unitOfWork;
    public IndexPage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Songs Page");
    }

    @Override
    protected void ShowContent(Object[] param) {
        String id = RouteParameterHelper.getParameter(param,0,String.class,null);
        List<Song> Songs;
        if(id != null){
            Songs = unitOfWork.getSongService().GetAll(p-> Objects.equals(p.getAlbumId(), id));
        }else{
            Songs = unitOfWork.getSongService().GetAll();
        }
        if(!Songs.isEmpty()) {
            Menu SongList = new Menu();
            for (Song Song : Songs) {
                SongList.addOption(Song.getTitle(), option -> {
                    Router.getInstance().navigate("Songs/Detail", Song.getId());
                });
            }
            SongList.navigateMenu("Song List");
        }
        else{
            InputHandler.WaitForKey("There is not any Song ,Press enter for back...");
            Router.getInstance().goBack();
        }
    }


}