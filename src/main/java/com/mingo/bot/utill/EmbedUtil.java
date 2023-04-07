package com.mingo.bot.utill;

import com.mingo.bot.domain.Embed;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class EmbedUtil {
    public EmbedBuilder embed(Embed embed){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle(embed.getTitle(), null);

        embedBuilder.setColor(embed.getColor());

        embedBuilder.setDescription(embed.getDescription());

        return embedBuilder;
    }
}
