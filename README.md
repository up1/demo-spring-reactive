# Demo :: Spring Reactive with WebFlux
* Spring WebFlux
* Spring Boot Testing
* Performance testing with [Gatling](https://gatling.io/)


### Step to run

Start web server
```
$mvnw clean spring-boot:run
```

Run performance testing
* Download Gatling
* Copy file `perf_test/RestSimulation.scala` to `user-files/simulations/`
```
$./bin/gatling.sh -s test.RestSimulation
```
