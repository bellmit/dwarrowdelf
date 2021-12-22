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

#### concepts

- threads and concurrency
- enums
- objects vs primitives
- lifecycle of objects
- access keywords
- builder patterns ( static )
- back to basics by Baeldung

#### libraries

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
- [ ] lombok
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

#### Baeldung

- Back to Basics [[>]](https://www.baeldung.com/java-tutorial)
- series [[>]](https://www.baeldung.com/category/series/)
- patterns [[>]](https://www.baeldung.com/tag/pattern/)
- creational-design-patterns [[>]](https://www.baeldung.com/creational-design-patterns)
- access-modifiers [[>]](https://www.baeldung.com/java-access-modifiers)
  - public [[>]](https://www.baeldung.com/java-public-keyword)
  - private [[>]](https://www.baeldung.com/java-private-keyword)
  - protected [[>]](https://www.baeldung.com/java-protected-access-modifier)
  - final [[>]](https://www.baeldung.com/java-final)
  - static [[>]](https://www.baeldung.com/java-static)
- finally [[>]](https://www.baeldung.com/java-finally-keyword)
- singleton [[>]](https://www.baeldung.com/java-static-class-vs-singleton)
- static-variables [[>]](https://www.baeldung.com/java-static-variables-initialization)
- constructors [[>]](https://www.baeldung.com/java-constructors-vs-static-factory-methods)
- creational-design-patterns [[>]](https://www.baeldung.com/creational-design-patterns)

#### Jacob Jenkov

- multi-threading tutorials [[>]](http://tutorials.jenkov.com/)
- videos [[>]](https://www.youtube.com/watch?v=mTGdtC9f4EU&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4)

### references

- Intro to JaCoCo [[>]](https://www.baeldung.com/jacoco)
- Lombok [[>]](https://projectlombok.org/features/all)
- Multi Module Project [[>]](https://www.baeldung.com/maven-multi-module)
- How to read a file in Java [[>]](https://www.baeldung.com/reading-file-in-java)
- Reading Java Properties [[>]](https://www.baeldung.com/java-properties)
- Spring Boot [[>]](https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/index.html)
- Spring Java Format [[>]](https://github.com/spring-io/spring-javaformat)
- Spring Kafka [[>]](https://docs.spring.io/spring-kafka/reference/html/)
- Swagger Editor [[>]](https://editor.swagger.io/)
- Tagging and Filtering JUnit Tests [[>]](https://www.baeldung.com/junit-filtering-tests    )
- Vavr [[>]](https://www.vavr.io/vavr-docs/)