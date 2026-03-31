package com.johnlima.telegrambot.client;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class IbovespaClient {

    private static final Logger log = LoggerFactory.getLogger(IbovespaClient.class);

    private final String token = System.getenv("BRAPI_TOKEN"); // pega do ENV do Render

    public String buscarIbovespa() {
        try {
            String url = "https://brapi.dev/api/quote/%5EBVSP?token=" + token;

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            log.info("Resposta da BRAPI: {}", response); // só pra debug

            JSONObject json = new JSONObject(response);

            if (json.has("results") && json.getJSONArray("results").length() > 0) {
                JSONObject index = json.getJSONArray("results").getJSONObject(0);
                if (index.has("regularMarketPrice")) {
                    double pontos = index.getDouble("regularMarketPrice");
                    return String.format("📊 IBOVESPA agora: %.2f pontos", pontos);
                }
            }

            return "Dados da IBOVESPA não disponíveis 😢";

        } catch (Exception e) {
            log.error("Erro ao buscar IBOVESPA", e);
            return "Erro ao buscar IBOVESPA 😢";
        }
    }
}