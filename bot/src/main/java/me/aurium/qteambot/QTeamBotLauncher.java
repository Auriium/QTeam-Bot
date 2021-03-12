package me.aurium.qteambot;

import me.aurium.beetle.api.Beetle;
import me.aurium.beetle.api.datacore.DataCore;
import org.javacord.api.DiscordApi;

/**
 * Initializes a bot with it's correct managers, handlers, commands, etc.
 *
 * The provided final bot should not need to do any of this.
 */
public class QTeamBotLauncher {

    private final Beetle beetle;
    private final DataCore operatingDataCore;
    private final DiscordApi api;

    QTeamBotLauncher(Beetle beetle, DataCore dataCore, DiscordApi discordApi) {
        this.beetle = beetle;
        this.operatingDataCore = dataCore;
        this.api = discordApi;
    }

    public QTeamBot launch() {



        return null;
    }

}
