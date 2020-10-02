# bankless


## Commands

**Console**

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

**Cassandra**

```
# connect to embedded Cassandra
export CQLSH_PORT=9042 ; export CQLSH_HOST=127.0.0.1 ; ./cqlsh -u cassandra -p cassandra
expand on; use bankless;

# queries
select * from accounts;
```

**Kafka**

```
# consume events in console
./kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 \
--consumer-property group.id=local-consumer-group --topic local-embedded-topic --from-beginning

# produce events from console
./kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic local-embedded-topic
```

### HTTP-API

Base URL: `http://localhost:8080`. Endpoints described in:
- `postman/bankless-java.postman_collection`
- `swagger/bankless-java.yaml`

## References

* [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/index.html)
* [JaCoCo Java + Maven Example](https://www.mkyong.com/maven/jacoco-java-code-coverage-maven-example/)
* [Lombok Features](https://projectlombok.org/features/all)
* [Code formatting](https://github.com/spring-io/spring-javaformat)
* [Swagger editor](https://editor.swagger.io/)