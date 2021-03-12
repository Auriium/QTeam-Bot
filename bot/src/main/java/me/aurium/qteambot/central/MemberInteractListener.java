package me.aurium.qteambot.central;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.member.ServerMemberBanEvent;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.event.server.member.ServerMemberLeaveEvent;
import org.javacord.api.listener.server.member.ServerMemberBanListener;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;
import org.javacord.api.listener.server.member.ServerMemberLeaveListener;

import java.awt.*;

/**
 * TODO: this could or maybe not track all users into sql, i'd rather not though
 */
public class MemberInteractListener implements ServerMemberJoinListener, ServerMemberLeaveListener, ServerMemberBanListener {

    private final CentralConfig centralConfig;
    private final TextChannel welcomeChannel;

    public MemberInteractListener(CentralConfig centralConfig, TextChannel welcomeChannel) {
        this.centralConfig = centralConfig;
        this.welcomeChannel = welcomeChannel;
    }

    @Override
    public void onServerMemberJoin(ServerMemberJoinEvent serverMemberJoinEvent) {
        if (centralConfig.areCentralMessagesEnabled()) {
            User user = serverMemberJoinEvent.getUser();

            new MessageBuilder()
                    .append(user)
                    .setEmbed(new EmbedBuilder()
                        .setDescription(String.format(centralConfig.getJoinMessage(),user.getName()))
                        .setColor(Color.GREEN)
                    ).send(welcomeChannel);
        }
    }

    @Override
    public void onServerMemberLeave(ServerMemberLeaveEvent serverMemberLeaveEvent) {
        if (centralConfig.areCentralMessagesEnabled()) {
            User user = serverMemberLeaveEvent.getUser();

            new MessageBuilder()
                    .append(user)
                    .setEmbed(new EmbedBuilder()
                            .setDescription(String.format(centralConfig.getLeaveMessage(),user.getName()))
                            .setColor(Color.RED)
                    ).send(welcomeChannel);
        }
    }

    @Override
    public void onServerMemberBan(ServerMemberBanEvent serverMemberBanEvent) {
        if (centralConfig.areCentralMessagesEnabled()) {
            User user = serverMemberBanEvent.getUser();

            new MessageBuilder()
                    .append(user)
                    .setEmbed(new EmbedBuilder()
                            .setDescription(String.format(centralConfig.getBannedMessage(),user.getName()))
                            .setColor(Color.BLACK)
                    ).send(welcomeChannel);
        }
    }
}
