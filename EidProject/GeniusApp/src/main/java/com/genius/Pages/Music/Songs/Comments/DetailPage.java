package com.genius.Pages.Music.Songs.Comments;

import com.AP.Cli.Menu;
import com.AP.Helpers.RouteParameterHelper;
import com.AP.Pages.Page;
import com.AP.Session;
import com.genius.Entities.Music.CommentReaction;
import com.genius.Enums.Reaction;
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
        String id = RouteParameterHelper.getParameter(param, 0, String.class, null);
        var comment = unitOfWork.getCommentService().GetById(id);
        if (comment == null) {
            System.out.println("Comment not found!");
            return;
        }
        System.out.println(comment);

        var reactions = unitOfWork.getCommentReactionService().GetAll(r -> r.getCommentId().equals(id));
        var userId = Session.getInstance().getCurrentAccount().getId();

        var userReaction = reactions.stream()
                .filter(r -> r.getUserId().equals(userId))
                .findFirst()
                .orElse(null);

        Menu menu = new Menu();

        if (userReaction != null) {
            String label = switch (userReaction.getReaction()) {
                case LIKE -> "Remove Like";
                case DISLIKE -> "Remove Dislike";
                case LAUGH -> "Remove :)";
                case SAD -> "Remove :(";
            };

            menu.addOption(label + " (" +
                            reactions.stream().filter(r -> r.getReaction() == userReaction.getReaction()).count() + ")",
                    options -> {
                        unitOfWork.getCommentReactionService().Delete(userReaction.getId());
                        ShowContent(new Object[]{id});
                    }
            );
        } else {

            for (Reaction reaction : Reaction.values()) {
                long count = reactions.stream().filter(r -> r.getReaction() == reaction).count();
                String label = switch (reaction) {
                    case LIKE -> "Like";
                    case DISLIKE -> "Dislike";
                    case LAUGH -> ":)";
                    case SAD -> ":(";
                };

                menu.addOption(label + " (" + count + ")", options -> {
                    unitOfWork.getCommentReactionService().Add(
                            new CommentReaction(id, userId, reaction)
                    );
                    ShowContent(new Object[]{id});
                });
            }
        }

        menu.navigateMenu("Reactions");
    }

}