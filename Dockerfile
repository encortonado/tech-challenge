# Usando uma imagem base do OpenJDK 17
FROM openjdk:20-jdk-slim

# Definindo o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiando o arquivo JAR gerado da aplicação para o contêiner
COPY target/challenge-0.0.1-SNAPSHOT.jar app.jar

# Expondo a porta que a aplicação irá rodar
EXPOSE 8080

# Definindo o comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
