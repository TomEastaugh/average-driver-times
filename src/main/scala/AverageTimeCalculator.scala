import scala.io.{BufferedSource, Source}

import com.typesafe.scalalogging.StrictLogging
import config.Config
import extractor.Extractor
import io.csv.CsvWriter
import transformer.Transformer

object AverageTimeCalculator extends App with StrictLogging {

  val cfg = Config()

  val source: BufferedSource = Source.fromResource(cfg.inputFileName)
  val lines = source.getLines.toList

  Extractor.extractCsv(lines) match {
    case Right(lapTimes) =>
      val averageLapTimes = Transformer.calculateAverage(lapTimes)
      CsvWriter.writeAverageTimes(averageLapTimes, cfg.outputFileName)

    case Left(errors) => logger.error(errors)
  }
  source.close()
}
