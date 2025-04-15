package com.genius.Pages.Artist.Songs;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;
import com.genius.Entities.Music.Song;
import com.genius.UnitOfWork;

import java.util.List;

public class IndexPage extends Page {
    private final UnitOfWork unitOfWork;
    public IndexPage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Index Page");
    }

    @Override
    protected void ShowContent(Object[] param) {
        List<Song> Songs = unitOfWork.getSongService().GetAll();
        Menu SongList = new Menu();
        SongList.addOption("Create",options -> {
            Router.getInstance().navigate("Songs/Upsert");
        });
        for (int i = 0;i< Songs.size() ;i++){
            var Song = Songs.get(i);
            var SongOptions = CreateCrudMenu(Song);
            SongList.addOption(Song.getTitle(),option -> {
                SongOptions.navigateMenu(Song.getTitle());
            });
        }
        SongList.navigateMenu("Song List");
    }

    private Menu CreateCrudMenu(Song Song) {
        var SongOptions = new Menu();
        SongOptions.addOption("Edit",options -> {
            Router.getInstance().navigate("Songs/Upsert", Song.getId());
        });
        SongOptions.addOption("Detail",options -> {
            Router.getInstance().navigate("Songs/Detail", Song.getId());
        });
        SongOptions.addOption("Delete",options -> {
            Router.getInstance().navigate("Songs/Delete", Song.getId());
        });
        return SongOptions;
    }
}