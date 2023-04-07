package com.mingo.bot.scheduler;

import com.mingo.bot.domain.Embed;
import com.mingo.bot.init.Client;
import com.mingo.bot.utill.EmbedUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class RecruitAlarmScheduler extends Client{

    public Long glennMessage;
    public Long hasidutMessage;

//    @Scheduled(cron = "* */38 * * * *")
//    public void glennCron() {
//
//        Embed embed = new Embed();
//        embed.setTitle("글렌 베르나 모집");
//        embed.setColor(Color.RED);
//        embed.setDescription("글렌 베르나 신청 주세요 \n 신청 방법은 1️⃣ 토요일, 2️⃣ 일요일로 반응을 눌러주세요.");
//
//
//        jda.getTextChannelById("1080754352463036508").sendMessage(new EmbedUtil().embed(embed).build()).queue((message) -> {
//            glennMessage = message.getIdLong();
//            message.addReaction("1️⃣").queue();
//            message.addReaction("2️⃣").queue();
//        });
//    }

    @Scheduled(cron = "00 50 21 * * *")
    public void hasidutCron() {

        Embed embed = new Embed();
        embed.setTitle("하시딤 레이드 모집");
        embed.setColor(Color.BLUE);
        embed.setDescription("하시딤 신청 주세요 \n 신청 방법은 👋 반응을 눌러주세요.");

        jda.getTextChannelById("1080754352463036508").sendMessage(new EmbedUtil().embed(embed).build()).queue((message) -> {
            hasidutMessage = message.getIdLong();
            message.addReaction("👋").queue();
        });
    }
}
