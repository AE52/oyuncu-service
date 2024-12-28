# 1. Aşama: Maven ile derleme
FROM maven:3.8.6-openjdk-17-slim AS build

# Çalışma dizinini ayarla
WORKDIR /app

# Pom.xml ve kaynak dosyalarını kopyala
COPY pom.xml ./
RUN mvn dependency:go-offline -B
COPY src ./src

# Uygulamayı derle
RUN mvn clean package -DskipTests

# 2. Aşama: Uygulamayı çalıştırmak için JRE kullan
FROM openjdk:17-jdk-slim

# Çalışma dizinini ayarla
WORKDIR /app

# Derlenen JAR dosyasını kopyala
COPY --from=build /app/target/*.jar app.jar

# Uygulamanın dinleyeceği portu aç
EXPOSE 8081

# Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "app.jar"]
