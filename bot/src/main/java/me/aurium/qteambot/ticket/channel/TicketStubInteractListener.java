package me.aurium.qteambot.ticket.channel;

import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;

/**
 * Listener that sparks the whole ticket creation
 */
public class TicketStubInteractListener implements ReactionAddListener {

    private ChannelDataHandler dataHandler;

    @Override
    public void onReactionAdd(ReactionAddEvent reactionAddEvent) {
        if (reactionAddEvent.getMessageId() == 13307) { //mockup



            reactionAddEvent.getUser().ifPresent(user -> {

            });
        }
    }
}
