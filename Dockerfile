FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/mbti-travel-company-0.0.1-SNAPSHOT.jar /app/mbti-travel-company.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mbti-travel-company.jar"]
