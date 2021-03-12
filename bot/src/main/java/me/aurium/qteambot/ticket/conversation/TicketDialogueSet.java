package me.aurium.qteambot.ticket.conversation;

import org.javacord.api.entity.channel.Channel;

import java.util.Collection;

public interface TicketDialogueSet {

    Collection<TicketDialogue> getAllDialogues();
    TicketDialogue getDialogueAtPosition(int position);

    Channel currentChannel();
    int timeoutDelay();

}
