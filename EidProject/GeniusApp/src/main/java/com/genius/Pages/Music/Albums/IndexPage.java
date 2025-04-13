package com.genius.Pages.Music.Albums;

import com.AP.Cli.FormHandler;
import com.AP.Cli.Menu;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Router;
import com.genius.Entities.Music.Album;
import com.genius.UnitOfWork;

import java.util.ArrayList;
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
        List<Album> albums = unitOfWork.getAlbumService().GetAll();
        Menu albumList = new Menu();
        albumList.addOption("Create",options -> {
            Router.getInstance().navigate("Albums/Upsert");
        });
        for (int i = 0;i< albums.size() ;i++){
            var album = albums.get(i);
            var albumOptions = CreateCrudMenu(album);
            albumList.addOption(album.getTitle(),option -> {
                albumOptions.navigateMenu(album.getTitle());
            });
        }
        albumList.navigateMenu("Album List");
    }

    private Menu CreateCrudMenu(Album album) {
        var albumOptions = new Menu();
        albumOptions.addOption("Edit",options -> {
            Router.getInstance().navigate("Albums/Upsert", album.getId());
        });
        albumOptions.addOption("Detail",options -> {
            Router.getInstance().navigate("Albums/Detail", album.getId());
        });
        albumOptions.addOption("Delete",options -> {
            Router.getInstance().navigate("Albums/Delete", album.getId());
        });
        return albumOptions;
    }
}