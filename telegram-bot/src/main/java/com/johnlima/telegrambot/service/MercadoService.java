package com.johnlima.telegrambot.service;

import com.johnlima.telegrambot.client.NewsClient;
import org.springframework.stereotype.Service;

@Service
public class MercadoService {


    private final NewsClient newsClient;

    public MercadoService( NewsClient newsClient) {

        this.newsClient = newsClient;
    }







    // ✅ Adicione este método
    public String getNoticiasGuerra() {
        return newsClient.buscarNoticiasGuerra();
    }
}