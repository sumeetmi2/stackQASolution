name := "test"

version := "1.0"

scalaVersion := "2.11.8"
lazy val root = (project in file(".")).enablePlugins(PlayScala,JavaAppPackaging).disablePlugins(PlayLayoutPlugin)

libraryDependencies +=  "com.typesafe.play" % "play-ws_2.11" % "2.5.14"




    