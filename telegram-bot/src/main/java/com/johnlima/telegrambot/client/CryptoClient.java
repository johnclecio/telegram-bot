package com.johnlima.telegrambot.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CryptoClient {

    private static final Logger log = LoggerFactory.getLogger(CryptoClient.class);
    private final RestTemplate rest = new RestTemplate();

    public double buscarPrecoBitcoin() {

        try {
            String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=brl";

            String response = rest.getForObject(url, String.class);
            JSONObject json = new JSONObject(response);

            return json.getJSONObject("bitcoin").getDouble("brl");

        } catch (Exception e) {
            log.error("Erro ao buscar preço do Bitcoin", e);
            return 0;
        }
    }
}