# Demo :: Spring Reactive with WebFlux
* Spring WebFlux
* Spring Boot Testing
* Performance testing with [Gatling](https://gatling.io/)


### Step to run

Run tesitng
```
$mvnw clean test
```

Start web server
```
$mvnw clean spring-boot:run
```
List of urls
* [REST](http://localhost:8080/users/v1)
* [WebFlux](http://localhost:8080/users/v2)

Run performance testing
* Download Gatling
* Copy file `perf_test/RestSimulation.scala` to `user-files/simulations/`
```
$./bin/gatling.sh -s test.RestSimulation
```
