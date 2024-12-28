# 1. Aşama: Maven ile derleme
FROM maven:3.8.6-openjdk-17-slim AS build

# Çalışma dizinini ayarla
WORKDIR /app

# Maven bağımlılıklarını önceden indirmek için sadece pom.xml'i kopyala
COPY pom.xml ./

# Bağımlılıkları indir (bağımlılıkların önbelleğe alınmasını sağlar)
RUN mvn dependency:go-offline -B

# Tüm kaynak dosyalarını kopyala
COPY src ./src

# Uygulamayı derle
RUN mvn clean package -DskipTests

# 2. Aşama: Uygulamayı çalıştırmak için JRE kullan
FROM openjdk:17-jdk-slim

# Çalışma dizinini ayarla
WORKDIR /app

# Derleme aşamasından JAR dosyasını kopyala
COPY --from=build /app/target/api-gateway-0.0.1-SNAPSHOT.jar app.jar

# Varsayılan portu belirt
EXPOSE 8081

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]
