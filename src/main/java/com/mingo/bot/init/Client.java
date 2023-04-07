package com.mingo.bot.init;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class Client implements DiscordBot{

    public JDA jda;

    public Client() {
        try {
            jda = JDABuilder.createDefault("MTA3NTA1NzM4NzYyMDI4MjM3OA.Gl5cZz.Zb_vEoSJAFH1_I8OlyCE5NNsSSjWZfw2T6eYnY")
                    .setActivity(Activity.playing("무기 박살내는 중!"))
                    .enableIntents(GatewayIntent.GUILD_EMOJIS, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES)
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .addEventListeners(new ClientListener())
                    .build();

            jda.awaitReady();

        }catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void sendMessage(String guild, String channel, String message) {
        try {
            jda
                    .getGuildById(guild)
                    .getTextChannelById(channel)
                    .sendMessage(message)
                    .queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
