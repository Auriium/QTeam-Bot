package me.aurium.qteambot.central;

public interface CentralConfig {

    boolean areCentralMessagesEnabled();

    String getJoinMessage();
    String getLeaveMessage();
    String getBannedMessage();

    long getWelcomeChannelID();
}
