package com.genius.Pages.Artist.Songs;

import com.AP.Cli.InputHandler;
import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Music.EditLyricsSuggest;
import com.genius.Entities.Music.Song;
import com.genius.UnitOfWork;

import java.util.List;
import java.util.Objects;

public class SuggestEditPage extends Page {
    private final UnitOfWork unitOfWork;
    public SuggestEditPage( UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Index Page");
    }
    @Override
    public boolean ShouldSaveInHistory(){
        return false;
    }
    @Override
    protected void ShowContent(Object[] param) {
        var Songs =  unitOfWork.getSongService().GetAll();
        for (var song : Songs) {
            var album = unitOfWork.getAlbumService().GetById(song.getAlbumId());
            if(!album.getUserId().equals(Session.getInstance().getCurrentAccount().getId())){
                continue;
            }
            var Suggests = unitOfWork.getEditLyricsSuggestService().GetAll(p -> p.getSongId().equals(song.getId()));
            if (!Suggests.isEmpty()) {
                    for (var suggest : Suggests) {
                        System.out.println(song.getId());
                        System.out.println(song.getTitle());
                        System.out.println(suggest.getLyrics());
                        Menu menu = getSuggestOptionsMenu(song, suggest);
                        menu.navigateMenu("");
                    }
            }
        }
            InputHandler.WaitForKey("There is not any Suggestion ,Press enter for back...");
            Router.getInstance().goBack();
    }

    private Menu getSuggestOptionsMenu(Song song, EditLyricsSuggest suggest) {
        Menu menu = new Menu();
        menu.addOption("Confirm", _ -> {
            song.setLyrics(suggest.getLyrics());
            unitOfWork.getSongService().Edit(song);
            unitOfWork.getEditLyricsSuggestService().Delete(suggest.getId());
        });
        menu.addOption("Reject", _ -> {
            song.setLyrics(suggest.getLyrics());
            unitOfWork.getSongService().Edit(song);
            unitOfWork.getEditLyricsSuggestService().Delete(suggest.getId());
        });
        return menu;
    }
}