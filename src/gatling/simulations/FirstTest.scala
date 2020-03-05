import io.gatling.core.scenario.Simulation

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class FirstTest extends Simulation {
  val httpConfig = http
    .baseUrl("http://echo-joewalker.127.0.0.1.nip.io")

  val scn = scenario("Go To GitHub")
    .exec(
      http("Get API version")
        .get("/index")
        .check(status.is(200))
    )

  setUp(
    scn.inject(
      constantUsersPerSec(500) during (30 seconds)
    )
  ).protocols(httpConfig)
}