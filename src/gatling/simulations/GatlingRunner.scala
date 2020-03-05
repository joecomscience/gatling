import io.gatling.core.config.GatlingPropertiesBuilder
import io.gatling.app.Gatling

object GatlingRunner {
  def main(args: Array[String]): Unit = {
    val simClass = classOf[FirstTest].getName
    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)
    Gatling.fromMap(props.build)
  }
}