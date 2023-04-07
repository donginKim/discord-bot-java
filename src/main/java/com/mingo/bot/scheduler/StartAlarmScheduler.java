package com.mingo.bot.scheduler;

import com.mingo.bot.domain.Embed;
import com.mingo.bot.init.Client;
import com.mingo.bot.utill.EmbedUtil;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class StartAlarmScheduler extends Client {
    
    private final RecruitAlarmScheduler recruitAlarmScheduler;

    public StartAlarmScheduler(RecruitAlarmScheduler recruitAlarmScheduler){
        this.recruitAlarmScheduler = recruitAlarmScheduler;
    }

    /**
     * 동시성 이슈로 인한 static 변수화
     */
    public static StringBuilder satGlenn = new StringBuilder();
    public static StringBuilder sunGlenn = new StringBuilder();
    public static StringBuilder hasidutList = new StringBuilder();

    @Scheduled(cron = "* * * */20 * *")
    public void glennSatCron() {
        Long glennMessage = recruitAlarmScheduler.glennMessage;
        TextChannel textChannel = jda.getTextChannelById("1080754352463036508");

        textChannel.retrieveMessageById(glennMessage).queue((message) -> {
            for(MessageReaction reaction : message.getReactions()) {
                if (reaction.getReactionEmote().getEmoji().equals("1️⃣")) {
                    reaction.retrieveUsers().queue((users) -> {
                        for(User user : users){
                            if(!user.isBot()) satGlenn.append("<@").append(user.getId()).append("> ");
                        }
                    });
                }
            }
        });

        Embed embed = new Embed();
        embed.setTitle("글렌 베르나");
        embed.setColor(Color.RED);

        if (satGlenn.length() <= 0) embed.setDescription("글렌 베르나 토요일 신청자가 없습니다.");
        else embed.setDescription("글렌 베르나 토요일 준비하세요.\n" + satGlenn);

        textChannel.sendMessage(new EmbedUtil().embed(embed).build()).queue();
        satGlenn = new StringBuilder();
    }

    @Scheduled(cron = "* * * */20 * *")
    public void glennSunCron() {
        Long glennMessage = recruitAlarmScheduler.glennMessage;
        TextChannel textChannel = jda.getTextChannelById("1080754352463036508");

        textChannel.retrieveMessageById(glennMessage).queue((message) -> {
            for(MessageReaction reaction : message.getReactions()) {
                if (reaction.getReactionEmote().getEmoji().equals("2️⃣")) {
                    reaction.retrieveUsers().queue((users) -> {
                        for(User user : users){
                            if(!user.isBot()) sunGlenn.append("<@").append(user.getId()).append("> ");
                        }
                    });
                }
            }
        });

        Embed embed = new Embed();
        embed.setTitle("글렌 베르나");
        embed.setColor(Color.RED);

        if (sunGlenn.length() <= 0) embed.setDescription("글렌 베르나 일요일 신청자가 없습니다.");
        else embed.setDescription("글렌 베르나 일요일 준비하세요.\n" + sunGlenn);

        textChannel.sendMessage(new EmbedUtil().embed(embed).build()).queue();
        sunGlenn = new StringBuilder();
        recruitAlarmScheduler.glennMessage = 0L;
    }

    @Scheduled(cron = "00 55 21 * * *")
    public void hasidutCron() {
        Long hasidutMessage = recruitAlarmScheduler.hasidutMessage;
        TextChannel textChannel = jda.getTextChannelById("1080754352463036508");

        textChannel.retrieveMessageById(hasidutMessage).queue((message) -> {
            for(MessageReaction reaction : message.getReactions()) {
                if (reaction.getReactionEmote().getEmoji().equals("👋")) {
                    reaction.retrieveUsers().queue((users) -> {
                        for(User user : users){
                            if(!user.isBot()) {
                                hasidutList.append("<@").append(user.getId()).append("> ");
                            }
                        }

                        Embed embed = new Embed();
                        embed.setTitle("하시딤 레이드");
                        embed.setColor(Color.BLUE);

                        if (hasidutList.length() >= 11) embed.setDescription("하시딤 레이드 준비하세요.\n" + hasidutList);
                        else embed.setDescription("하시딤 인원이 충족하지 않아 취소되었습니다.");

                        textChannel.sendMessage(new EmbedUtil().embed(embed).build()).queue();
                    });
                }
            }
        });

        hasidutList = new StringBuilder();
        recruitAlarmScheduler.hasidutMessage = 0L;
    }
}
