package model

case class DriverLapTimes(driver: String, averageTime: Double, minTime: Double) {
  override def toString: String = s"$driver,$averageTime"
}
