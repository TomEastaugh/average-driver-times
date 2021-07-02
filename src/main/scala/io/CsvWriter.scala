package io

import java.io.{BufferedWriter, File, FileWriter}

import com.typesafe.scalalogging.StrictLogging
import model.DriverLapTimes

object CsvWriter extends StrictLogging {
  def writeAverageTimes(averageLapTimes: List[DriverLapTimes]): Unit = {

    val contents = averageLapTimes.map(_.toString).mkString("\n")

    val file = new File("average-times.csv")

    val buffer = new BufferedWriter(new FileWriter(file))

    buffer.write(contents)

    buffer.close()

    logger.info("Successfully written file 'average-times.csv'")
  }
}
