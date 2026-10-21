# Image de base avec le runtime Java
FROM eclipse-temurin:21-jdk

# Auteur de l'image
LABEL "org.opencontainers.image.authors"="douaa.com"

# Ajouter le jar de l'application dans l'image
COPY target/couleur-microservice-0.0.1-SNAPSHOT.jar couleur-microservice-0.0.1-SNAPSHOT.jar

# Exécuter l'application
ENTRYPOINT ["java", "-jar", "couleur-microservice-0.0.1-SNAPSHOT.jar"]