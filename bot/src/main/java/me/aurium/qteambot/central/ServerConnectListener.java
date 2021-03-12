package me.aurium.qteambot.central;

import me.aurium.beetle.api.Beetle;
import org.javacord.api.event.server.ServerJoinEvent;
import org.javacord.api.event.server.ServerLeaveEvent;
import org.javacord.api.listener.server.ServerJoinListener;
import org.javacord.api.listener.server.ServerLeaveListener;

public class ServerConnectListener implements ServerJoinListener, ServerLeaveListener {

    private final Beetle beetle;

    public ServerConnectListener(Beetle beetle) {
        this.beetle = beetle;
    }

    @Override
    public void onServerJoin(ServerJoinEvent serverJoinEvent) {
        beetle.getLogger().info("Discord | Bot has joined server!" +
                " Name: " + serverJoinEvent.getServer().getName() +
                " ID: " + serverJoinEvent.getServer().getIdAsString());
    }

    @Override
    public void onServerLeave(ServerLeaveEvent serverLeaveEvent) {
        beetle.getLogger().info("Discord | Bot has left server!" +
                " Name: " + serverLeaveEvent.getServer().getName() +
                " ID: " + serverLeaveEvent.getServer().getIdAsString());
    }
}
