package extractor

import model.LapTime
import org.scalatest.{FlatSpec, Matchers}

class ExtractorSpec extends FlatSpec with Matchers {

  behavior of "Extractor"

  it should "extract a list LapTimes from a valid list of csv strings" in {
    val input = List(
      "Thomas,3.2",
      "David, 2.0",
      "Longer,2.4,ignored"
    )
    val expected = List(
      LapTime("Thomas", 3.2),
      LapTime("David", 2.0),
      LapTime("Longer", 2.4)
    )

    Extractor.extractCsv(input) shouldEqual Right(expected)
  }

  it should "return an error string given an invalid double value for time" in {
    val input = List("Invalid,qwerty")
    Extractor.extractCsv(input) shouldEqual Left("java.lang.NumberFormatException: For input string: \"qwerty\"")
  }

  it should "return an error string given an invalid csv line" in {
    val input = List("Wrong")
    Extractor.extractCsv(input) shouldEqual Left("java.lang.ArrayIndexOutOfBoundsException: 1")
  }

}
