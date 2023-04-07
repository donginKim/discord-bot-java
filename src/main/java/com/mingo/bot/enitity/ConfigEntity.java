package com.mingo.bot.enitity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigEntity {
    @Value("${discord.bot.token}")
    private String configToken;

    public String getConfigToken(){
        return configToken;
    }
}
