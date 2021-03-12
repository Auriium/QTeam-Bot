package me.aurium.qteambot.utils;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class MessageUtils {

    public static void changeEmbedColor(Message message, Color color) {

        List<EmbedBuilder> embeds = new LinkedList<>();

        message.getEmbeds().forEach(embed -> {
            embeds.add(embed.toBuilder().setColor(color));
        });

        /// FIXME: 3/12/21 figure out if i can iterate over embeds or if message only takes one embed
        message.edit(embeds.get(0));
    }

}
