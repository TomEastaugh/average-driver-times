import scala.io.{BufferedSource, Source}

import com.typesafe.scalalogging.StrictLogging
import extractor.Extractor
import io.csv.CsvWriter
import transformer.Transformer

object Processor extends App with StrictLogging {
  val source: BufferedSource = Source.fromResource("driver-times.csv")
  val lines = source.getLines.toList

  Extractor.extractCsv(lines) match {
    case Right(lapTimes) =>
      val averageLapTimes = Transformer.calculateAverage(lapTimes)
      CsvWriter.writeAverageTimes(averageLapTimes)

    case Left(errors) => logger.error(errors)
  }
  source.close()
}
