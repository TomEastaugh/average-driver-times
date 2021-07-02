package io.csv

import scala.io.Source

import model.DriverLapTimes
import org.scalatest.{FlatSpec, Matchers}

class CsvWriterSpec extends FlatSpec with Matchers {

  behavior of "CsvWriter"

  it should "correctly write average driven times given a valid list of DriverLapTimes" in {

    val input = List(
      DriverLapTimes("Thomas", 2.123, 2.02),
      DriverLapTimes("Pedro", 1.23, 1.11),
      DriverLapTimes("Charlie", 5.77, 4.68)
    )

    val expected = List(
      "Thomas,2.123",
      "Pedro,1.23",
      "Charlie,5.77"
    )

    CsvWriter.writeAverageTimes(input)

    Source.fromFile(CsvWriter.fileName).getLines.toList should contain theSameElementsAs expected

  }
}
