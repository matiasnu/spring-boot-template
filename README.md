# Spring Boot Template
### Integrations
- Swagger
- Docker
- Liquibase
- Kafka

### Build Image
`./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=demo/demo:building`
#### Skip Test
`./mvnw spring-boot:build-image -DskipTests -Dspring-boot.build-image.imageName=demo/demo:building`