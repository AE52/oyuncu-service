# Temel imaj olarak OpenJDK kullanıyoruz
FROM openjdk:17-jdk-slim

# Uygulama için bir dizin oluştur
WORKDIR /app

# Maven ile derleme için gerekli dosyaları kopyala
COPY pom.xml .
COPY src ./src

# Maven ile uygulamayı derle
RUN apt-get update && apt-get install -y maven && \
    mvn clean package -DskipTests

# Uygulama jar dosyasını kopyala
COPY target/api-gateway-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]

# Uygulamanın dinleyeceği port
EXPOSE 8081