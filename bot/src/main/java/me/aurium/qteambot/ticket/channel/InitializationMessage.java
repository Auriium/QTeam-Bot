package me.aurium.qteambot.ticket.channel;

import me.aurium.qteambot.ticket.TicketType;

public class InitializationMessage {

    public InitializationMessage(TicketType type, long messageID) {
        this.type = type;
        this.messageID = messageID;
    }

    public TicketType getType() {
        return type;
    }

    public long getMessageID() {
        return messageID;
    }

    private final TicketType type;
    private final long messageID;

}
