val coreDeps = Seq(
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-csv" % "2.12.3",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"
)

val testDeps = Seq("org.scalatest" %% "scalatest" % "3.0.8" % Test)

val deps = coreDeps ++ testDeps

val root = (project in file(".")).settings(
  name := "average-driver-times",
  version := "0.1",
  organization := "com.sky",
  scalaVersion := "2.13.6",
  libraryDependencies ++= deps
)
