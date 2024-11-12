# Etapa de construção
FROM maven:3.8.4-openjdk-17 AS build
# Copiar o código-fonte para o contêiner
WORKDIR /opt/app
COPY ./ /opt/app
# Compilar o código-fonte
RUN mvn clean install -DskipTests
# Etapa de produção
FROM openjdk:19-jdk-alpine
# Copiar o JAR compilado da etapa de construção
COPY --from=build /opt/app/target/*.jar app.jar
# Definir variáveis de ambiente
ENV PORT=8085
ENV API_NAME="api-insurance-calculator"
# Expor a porta
EXPOSE $PORT
# Executar a aplicação
ENTRYPOINT ["java", "-jar", "-Xmx512M", "-Dserver.port=${PORT}", "-Dapi.name=${API_NAME}", "app.jar"]