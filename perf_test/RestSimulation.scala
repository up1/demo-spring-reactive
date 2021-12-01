package test
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
class RestSimulation extends Simulation {

  val httpProtocol = http.baseUrl("http://localhost:8080")

  val scn = scenario("RestSimulation")
    .exec(http("rest").get("/users/v1"))
    .pause(23)
    .exec(http("webflux").get("/users/v2"))
    .pause(39)

  setUp(scn.inject(atOnceUsers(300))).protocols(httpProtocol)
}