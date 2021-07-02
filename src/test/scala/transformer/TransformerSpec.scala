package transformer

import model.{DriverLapTimes, LapTime}
import org.scalatest.{FlatSpec, Matchers}

class TransformerSpec extends FlatSpec with Matchers {

  behavior of "Transformer"

  it should "extract a the top 3 drivers by average lap time from a valid list LapTimes" in {
    val input = List(
      LapTime("Thomas", 2),
      LapTime("Thomas", 4),
      LapTime("David", 4),
      LapTime("Ben", 1),
      LapTime("Ben", 9),
      LapTime("Ben", 5),
      LapTime("Ignored", 10),
    )

    val expected = List(
      DriverLapTimes("Thomas", 3, 2),
      DriverLapTimes("David", 4, 4),
      DriverLapTimes("Ben", 5, 1)
    )

    Transformer.calculateAverage(input) should contain theSameElementsInOrderAs expected
  }

  it should "order drivers by min lap time when average lap times are equal" in {
    val input = List(
      LapTime("Thomas", 2),
      LapTime("Thomas", 4),
      LapTime("David", 4),
      LapTime("Ben", 1),
      LapTime("Ben", 8),
      LapTime("Ben", 3)
    )

    val expected = List(
      DriverLapTimes("Thomas", 3, 2),
      DriverLapTimes("Ben", 4, 1),
      DriverLapTimes("David", 4, 4),
    )

    Transformer.calculateAverage(input) should contain theSameElementsInOrderAs expected
  }

}
