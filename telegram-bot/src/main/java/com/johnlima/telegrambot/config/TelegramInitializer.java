package com.johnlima.telegrambot.config;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.johnlima.telegrambot.controler.TelegramBot;

@Component
public class TelegramInitializer {

    public TelegramInitializer(TelegramBot bot) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);

            System.out.println("🤖 Bot iniciado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}