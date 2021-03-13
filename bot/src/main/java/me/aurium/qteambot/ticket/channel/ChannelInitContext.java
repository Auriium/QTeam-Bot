package me.aurium.qteambot.ticket.channel;

import me.aurium.qteambot.ticket.TicketType;
import org.javacord.api.entity.user.User;

/**
 * All data for initialization
 */
public class ChannelInitContext {

    public ChannelInitContext(User channelInitializer, TicketType ticketType) {
        this.channelInitializer = channelInitializer;
        this.ticketType = ticketType;
    }

    public User getChannelInitializer() {
        return channelInitializer;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    private final User channelInitializer;
    private final TicketType ticketType;

}
