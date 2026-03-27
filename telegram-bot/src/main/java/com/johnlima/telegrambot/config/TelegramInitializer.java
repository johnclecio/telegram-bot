package com.johnlima.telegrambot.config;

import com.johnlima.telegrambot.controler.TelegramBot;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;






@Configuration
public class TelegramInitializer {

    @Autowired
    private TelegramBot bot;

    @PostConstruct
    public void init() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
            System.out.println("🤖 Bot iniciado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}