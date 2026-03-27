🚀 Telegram Bot - Mercado & Notícias

Bot desenvolvido com Spring Boot que integra APIs externas para fornecer informações em tempo real diretamente no Telegram.

📌 Funcionalidades
💰 Consulta do preço do Bitcoin
📊 Consulta do índice IBOVESPA (mock)
🌍 Últimas notícias sobre guerra (API externa)
🤖 Interação via comandos no Telegram
🛠️ Tecnologias utilizadas
☕ Java 21
🌱 Spring Boot
🤖 Telegram Bots API
🌐 REST APIs (GNews, Crypto)
📦 Maven
🔧 Lombok
📂 Estrutura do projeto
        src/main/java/com/johnlima/telegrambot
        │
        ├── config
        │   └── BotConfig.java
        │
        ├── controler
        │   └── TelegramBot.java
        │
        ├── service
        │   └── MercadoService.java
        │
        ├── client
        │   ├── CryptoClient.java
        │   └── NewsClient.java
        │
        └── TelegramBotApplication.java
⚙️ Configuração

No arquivo application.yml:

telegram:
bot:
token: SEU_TOKEN
username: SEU_USERNAME

news:
api:
key: SUA_API_KEY
▶️ Como executar
./mvnw clean install
./mvnw spring-boot:run
💬 Comandos disponíveis

No Telegram, envie:

bitcoin
bovespa
guerra
🔐 Observações
As chaves de API devem ser mantidas seguras
Recomenda-se o uso de variáveis de ambiente em produção
🚀 Melhorias futuras
Comandos com /start, /menu
Interface com botões no Telegram
Integração com banco de dados
Cache de consultas
Integração com planilhas (estoque)