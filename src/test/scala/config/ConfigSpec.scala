package config

import org.scalatest.{FlatSpec, Matchers}

class ConfigSpec extends FlatSpec with Matchers {
  "The application.conf" should "be parsed correctly" in {
    val cfg = Config()
    cfg.inputFileName shouldEqual "test-driver-times.csv"
    cfg.outputFileName shouldEqual "test-average-driver-times.csv"
  }
}
