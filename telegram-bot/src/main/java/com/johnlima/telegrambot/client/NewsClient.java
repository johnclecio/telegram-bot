package com.johnlima.telegrambot.client;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Component
public class NewsClient {

    private final String apiKey;

    public NewsClient(@Value("${news.api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    public String buscarNoticiasGuerra() {
        try {
            String url = "https://gnews.io/api/v4/search?q=guerra+ucrania+russia&lang=pt&max=5&apikey=" + apiKey;

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            JSONObject json = new JSONObject(response);
            JSONArray articles = json.getJSONArray("articles");

            StringBuilder noticias = new StringBuilder("📰 Notícias de Guerra:\n\n");

            for (int i = 0; i < articles.length(); i++) {
                JSONObject artigo = articles.getJSONObject(i);

                String titulo = artigo.getString("title");
                String link = artigo.getString("url");

                noticias.append("👉 ").append(titulo).append("\n")
                        .append(link).append("\n\n");
            }

            return noticias.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao buscar notícias 😢";
        }
    }
}

//./mvnw spring-boot:run