package com.johnlima.telegrambot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig {

    @Value("${telegram.bot.token}")
    private String token;

    @Value("${telegram.bot.username}")
    private String username;

    // ✅ ADICIONA ISSO
    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }
}