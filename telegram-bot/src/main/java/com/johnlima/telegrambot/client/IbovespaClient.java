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

    // Token da API BRAPI (se houver)
    @Value("${ibovespa.api.token:}")
    private String token;

    private final RestTemplate restTemplate = new RestTemplate();

    public String buscarIbovespa() {
        try {
            // URL da API, adicionando token se existir
            String url = "https://brapi.dev/api/quote/%5EBVSP";
            if (token != null && !token.isEmpty()) {
                url += "?token=" + token;
            }

            // Fazendo a requisição HTTP
            String response = restTemplate.getForObject(url, String.class);
            log.info("Resposta da API Ibovespa: {}", response);

            JSONObject json = new JSONObject(response);

            // Verifica se "results" existe e tem elementos
            if (json.has("results") && json.getJSONArray("results").length() > 0) {
                JSONObject primeiro = json.getJSONArray("results").getJSONObject(0);

                // Verifica se "regularMarketPrice" existe
                if (primeiro.has("regularMarketPrice")) {
                    double pontos = primeiro.getDouble("regularMarketPrice");
                    return String.format("📊 IBOVESPA agora: %.2f pontos", pontos);
                }
            }

            log.warn("Dados de IBOVESPA não encontrados no JSON");
            return "IBOVESPA indisponível no momento 😢";

        } catch (Exception e) {
            log.error("Erro ao buscar IBOVESPA", e);
            return "Erro ao buscar IBOVESPA 😢";
        }
    }
}