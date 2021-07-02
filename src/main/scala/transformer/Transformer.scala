package transformer

import model.{DriverLapTimes, LapTime}

object Transformer {
  def calculateAverage(lapTimes: List[LapTime]): List[DriverLapTimes] = {
    val avgDriverTimes = lapTimes.groupBy(_.driver).map {
      case (driverName, lapTime) =>
        val times = lapTime.map(_.time)
        val averageTime = times.sum / times.size
        DriverLapTimes(driverName, averageTime, times.min)
    }.toList

    avgDriverTimes.sortBy(dt => (dt.averageTime, dt.minTime)).take(3)
  }
}
