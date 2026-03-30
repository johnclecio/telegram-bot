# Usa Java 21
FROM eclipse-temurin:21-jdk

# Pasta da aplicação
WORKDIR /app

# Copia tudo
COPY . .

# Dá permissão pro mvnw (caso tenha)
RUN chmod +x mvnw || true

# Build do projeto
RUN ./mvnw clean package || mvn clean package

# Porta do Spring
EXPOSE 8080

# Rodar aplicação
CMD ["java", "-jar", "target/telegram-bot-0.0.1-SNAPSHOT.jar"]