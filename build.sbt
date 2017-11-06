
name := "authentication"

version := "1.0-SNAPSHOT"

updateOptions := updateOptions.value.withCachedResolution(true)

scalaVersion := "2.11.8"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "net.sf.barcode4j" % "barcode4j" % "2.0",
  "javax.inject" % "javax.inject" % "1",
  "mysql" % "mysql-connector-java" % "5.1.24",
  "org.scalikejdbc" %% "scalikejdbc"                  % "2.4.0",
  "org.scalikejdbc" %% "scalikejdbc-config"           % "2.4.0",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.5.1",
  "com.typesafe.play" %% "play-test" % "2.5.4" % "test",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % "test"
)
        