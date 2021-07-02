package io.csv

import java.io.{BufferedWriter, File, FileWriter}

import com.typesafe.scalalogging.StrictLogging
import model.DriverLapTimes

object CsvWriter extends StrictLogging {

  val fileName = "average-times.csv"

  def writeAverageTimes(averageLapTimes: List[DriverLapTimes]): Unit = {
    val contents = averageLapTimes.map(_.toString).mkString("\n")
    val file = new File(fileName)
    val buffer = new BufferedWriter(new FileWriter(file))

    buffer.write(contents)
    buffer.close()

    logger.info(s"Successfully written file '$fileName'")
  }
}
