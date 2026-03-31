package com.johnlima.telegrambot.client;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class IbovespaClient {

    private static final Logger log = LoggerFactory.getLogger(IbovespaClient.class);

    private final RestTemplate restTemplate = new RestTemplate();

    // Injeta o token da variável de ambiente
    @Value("${ibovespa.api.token}")
    private String token;

    public String buscarIbovespa() {
        try {
            String url = "https://brapi.dev/api/quote/%5EBVSP?token=" + token;

            String response = restTemplate.getForObject(url, String.class);

            JSONObject json = new JSONObject(response);
            double pontos = json.getJSONArray("results")
                    .getJSONObject(0)
                    .getDouble("regularMarketPrice");

            return String.format("📊 IBOVESPA agora: %.2f pontos", pontos);

        } catch (Exception e) {
            log.error("Erro ao buscar IBOVESPA", e);
            return "Erro ao buscar IBOVESPA 😢";
        }
    }
}