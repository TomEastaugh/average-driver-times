package config

import com.typesafe.config.{ConfigFactory, Config => TConfig}

class Config(cfg: TConfig) {
  val inputFileName = cfg.getString("input.fileName")
  val outputFileName = cfg.getString("output.fileName")
}

object Config {
  import ConfigFactory.load
  def apply(): Config = new Config(load.getConfig("average-driver-times"))
}