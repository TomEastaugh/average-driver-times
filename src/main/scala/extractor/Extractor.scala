package extractor

import scala.util.{Failure, Success, Try}

import model.LapTime

object Extractor {

  def extractCsv(csvLines: List[String]): Either[String, List[LapTime]] = {
    Try {
      for {
        line <- csvLines
        values = line.split(",").map(_.trim)
      } yield LapTime(values(0), values(1).toDouble)
    }
  } match {
    case Failure(error) => Left(error.toString)
    case Success(value) => Right(value)
  }
}
