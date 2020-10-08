# bankless


## Console

```
# run local
./mvnw clean compile test
./mvnw spring-boot:run

# run .jar file
./mvnw package
java -jar target/bankless-java-0.1.0.jar

# format code
./mvnw spring-javaformat:apply
```

## Tests

* `@Tag("unit")`
* `@Tag("component")`
* Deployment tests are tagged with `@SpringBootTest` and `@ActiveProfiles({ "test" })`

## Cassandra

#### Tables

- accounts

#### Console

```
# connect to embedded Cassandra
export CQLSH_PORT=9042 ; export CQLSH_HOST=127.0.0.1 ; ./cqlsh -u cassandra -p cassandra
expand on; use bankless;

# queries
select * from accounts;
```

## Kafka

#### Console

#### Topics

- local-embedded-topic
- local-account-opened

#### Events

```
# local-account-opened
2010-10-10 10:10:00;CAN;800001;350000
```

```
# consume events in console
./kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 \ 
--consumer-property group.id=local-consumer-group --topic local-embedded-topic --from-beginning
./kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 \
--consumer-property group.id=local-consumer-group --topic local-account-opened --from-beginning

# produce events from console
./kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic local-embedded-topic
./kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic local-account-opened
```

## HTTP

Base URL: `http://localhost:8080`. Endpoints described in:
- `postman/bankless-java.postman_collection`
- `swagger/bankless-java.yaml`

## References

* [Code formatting](https://github.com/spring-io/spring-javaformat)
* [Lombok](https://projectlombok.org/features/all)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/index.html)
* [Spring Kafka](https://docs.spring.io/spring-kafka/reference/html/)
* [Swagger](https://editor.swagger.io/)
* [Vavr](https://www.vavr.io/vavr-docs/)