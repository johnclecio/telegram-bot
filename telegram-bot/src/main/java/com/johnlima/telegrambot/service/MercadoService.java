package com.johnlima.telegrambot.service;

import com.johnlima.telegrambot.client.CryptoClient;
import com.johnlima.telegrambot.client.IbovespaClient;
import com.johnlima.telegrambot.client.NewsClient;
import org.springframework.stereotype.Service;

@Service
public class MercadoService {

    private final CryptoClient cryptoClient;
    private final IbovespaClient ibovespaClient;

    public MercadoService(CryptoClient cryptoClient, IbovespaClient ibovespaClient) {
        this.cryptoClient = cryptoClient;
        this.ibovespaClient = ibovespaClient;
    }

    public String getPrecoBitcoin() {
        double valor = cryptoClient.buscarPrecoBitcoin();

        if (valor == 0) {
            return "Erro ao buscar Bitcoin 😢";
        }

        return String.format("💰 Bitcoin agora: R$ %.2f", valor);
    }

    public String getIbovespa() {
        return ibovespaClient.buscarIbovespa();
    }
}