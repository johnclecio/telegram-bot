package com.johnlima.telegrambot.controler;

import com.johnlima.telegrambot.config.BotConfig;
import com.johnlima.telegrambot.service.MercadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private BotConfig botConfig;

    @Autowired
    private MercadoService mercadoService;

    @Override
    public String getBotUsername() {
        return botConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            String mensagem = update.getMessage().getText().toLowerCase();
            String chatId = update.getMessage().getChatId().toString();

            String resposta;

            // 🔥 COMANDO DO BOT
            if (mensagem.contains("guerra")) {
                resposta = mercadoService.getNoticiasGuerra();
            } else {
                resposta = """
                🤖 Comandos disponíveis:
                - guerra
                """;
            }

            enviarMensagem(chatId, resposta);
        }
    }

    private void enviarMensagem(String chatId, String texto) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(texto);

        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}