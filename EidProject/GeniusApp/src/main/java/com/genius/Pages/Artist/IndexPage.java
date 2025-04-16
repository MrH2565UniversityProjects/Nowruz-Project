package com.genius.Pages.Artist;

import com.AP.Cli.Menu;
import com.AP.Pages.Page;
import com.AP.Router;
import com.AP.Session;
import com.genius.Entities.Identity.Artist;
import com.genius.Entities.Identity.Artist;
import com.genius.Entities.Identity.FollowingArtists;
import com.genius.UnitOfWork;

import java.util.List;

public class IndexPage extends Page {
    private final UnitOfWork unitOfWork;
    public IndexPage(UnitOfWork unitOfWork) {
        this.unitOfWork = unitOfWork;
    }
    @Override
    public void Initialize() {
        setName("Index Page");
    }

    @Override
    protected void ShowContent(Object[] param) {
        List<Artist> Artists = unitOfWork.getArtistService().GetAll();
        Menu ArtistList = new Menu();
        for (Artist Artist : Artists) {
            var ArtistOptions = CreateArtistMenu(Artist);
            ArtistList.addOption(Artist.getName(), option -> {
                ArtistOptions.navigateMenu(Artist.getId());
            });
        }
        ArtistList.navigateMenu("Artist List");
    }

    private Menu CreateArtistMenu(Artist Artist) {
        var ArtistOptions = new Menu();
        var followingArtist = unitOfWork.getFollowingArtistsService().GetAll(
                p->p.getArtistId().equals(Artist.getId()) &&
                        p.getUserId().equals(Session.getInstance().getCurrentAccount().getId())).stream().findFirst()
                .orElse(null);
        if(followingArtist != null){
            ArtistOptions.addOption("Unfollow",options -> {
                unitOfWork.getFollowingArtistsService().Delete(followingArtist.getId());
            });
        }else{
            ArtistOptions.addOption("Follow",options -> {
                unitOfWork.getFollowingArtistsService().Add(new FollowingArtists(Session.getInstance().getCurrentAccount().getId(), Artist.getId()));
            });
        }

        ArtistOptions.addOption("Detail",options -> {
            Router.getInstance().navigate("Artist/Detail", Artist.getId());
        });
        /*ArtistOptions.addOption("Albums",options -> {
            Router.getInstance().navigate("Albums", Artist.getId());
        });
        ArtistOptions.addOption("Songs",options -> {
            Router.getInstance().navigate("Songs", Artist.getId());
        });*/
        return ArtistOptions;
    }
}