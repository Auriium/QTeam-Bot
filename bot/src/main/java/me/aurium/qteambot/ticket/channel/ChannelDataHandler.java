package me.aurium.qteambot.ticket.channel;

import me.aurium.beetle.api.datacore.DataCore;
import me.aurium.beetle.api.datacore.Transact;
import me.aurium.qteambot.sources.tables.records.TicketCreationMessagesRecord;
import me.aurium.qteambot.ticket.TicketType;
import org.jooq.DSLContext;
import org.jooq.Result;

import static me.aurium.qteambot.sources.tables.TicketCreationMessages.TICKET_CREATION_MESSAGES;

import java.util.Optional;

public class ChannelDataHandler {

    private DataCore dataCore;

    public Optional<InitializationMessage> getInitializationMessage(Transact transact, String id) {
        TicketCreationMessagesRecord result = transact.getProperty(DSLContext.class).selectFrom(TICKET_CREATION_MESSAGES)
                .where(TICKET_CREATION_MESSAGES.MESSAGE_ID.eq(id)).fetchOne();

        if (result == null) return Optional.empty();

        TicketType type = TicketType.valueOf(result.getTicketCreationType().toString());
        result.getMessageId();
    }

}
