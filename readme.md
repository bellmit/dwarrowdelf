# dwarrowdef

## contents

* [commands](#commands)
* [modules](#modules)
* [topics](#topics)
* [references](#references)

### commands

```
# compile
mvn clean spring-javaformat:apply compile test
mvn package

# run
mvn exec:java -pl core-domain
mvn exec:java -pl mod-http

mvn -pl mod-http spring-boot:run
```

### modules

- core-domain
- http

### topics

- [ ] cache
- [X] cassandra
- [X] configuration
- [ ] circuit breakers
- [ ] cqrs
- [ ] elasticsearch
- [ ] eureka
- [ ] event store
- [ ] hystrix
- [ ] h2 database
- [ ] interceptors
- [ ] java basics
- [ ] jmeter
- [ ] jwt
- [ ] kafka
- [X] logging
- [ ] logging context
- [ ] metrics
- [ ] micrometer
- [ ] mockito
- [X] mvn modules
- [X] postman
- [ ] protobuf
- [ ] rabbit-mq
- [ ] request filters
- [ ] rpc
- [ ] rest client / template
- [ ] retries
- [ ] spark
- [X] swagger
- [ ] vavr
- [ ] xml

### references

* [Baeldung Series](https://www.baeldung.com/category/series/)
* [Intro to JaCoCo](https://www.baeldung.com/jacoco)
* [Java "Back to Basics"](https://www.baeldung.com/java-tutorial)
* [Lombok](https://projectlombok.org/features/all)
* [Multi Module Project](https://www.baeldung.com/maven-multi-module)
* [How to read a file in Java](https://www.baeldung.com/reading-file-in-java)
* [Reading Java Properties](https://www.baeldung.com/java-properties)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/index.html)
* [Spring Java Format](https://github.com/spring-io/spring-javaformat)
* [Spring Kafka](https://docs.spring.io/spring-kafka/reference/html/)
* [Swagger Editor](https://editor.swagger.io/)
* [Tagging and Filtering JUnit Tests](https://www.baeldung.com/junit-filtering-tests    )
* [Vavr](https://www.vavr.io/vavr-docs/)