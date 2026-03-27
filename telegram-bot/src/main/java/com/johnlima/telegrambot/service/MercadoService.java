package com.johnlima.telegrambot.service;

import com.johnlima.telegrambot.client.CryptoClient;
import com.johnlima.telegrambot.client.NewsClient;
import org.springframework.stereotype.Service;

@Service
public class MercadoService {

    private final CryptoClient cryptoClient;
    private final NewsClient newsClient;

    // 👇 injeta os DOIS aqui
    public MercadoService(CryptoClient cryptoClient, NewsClient newsClient) {
        this.cryptoClient = cryptoClient;
        this.newsClient = newsClient;
    }

    public String getPrecoBitcoin() {

        double valor = cryptoClient.buscarPrecoBitcoin();

        if (valor == 0) {
            return "Erro ao buscar Bitcoin 😢";
        }

        return String.format("💰 Bitcoin agora: R$ %.2f", valor);
    }

    public String getIbovespa() {
        return "📊 IBOVESPA: 130.000 pontos (mock)";
    }

    public String getNoticiasGuerra() {
        return newsClient.buscarNoticiasGuerra();
    }
}