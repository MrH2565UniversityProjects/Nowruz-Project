package com.genius.Pages.Artist.Songs;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
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
    protected void ShowContent(Object[] param) {
       var Suggests = unitOfWork.getEditLyricsSuggestService().GetAll(p -> Objects.equals(p.getUserId(), Session.getInstance().getCurrentAccount().getId()));
         if(!Suggests.isEmpty()) {
             var suggest = Suggests.getFirst();
             var song = unitOfWork.getSongService().GetById(suggest.getSongId());
             System.out.println(song.getId());
             System.out.println(song.getTitle());
             System.out.println(suggest.getLyrics());
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
             menu.navigateMenu("");
         }
    }
}