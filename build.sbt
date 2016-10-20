name := "sbt-sandbox"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(

  "org.scalaz"                      %% "scalaz-core"       % "7.2.0",
  "org.scala-lang.modules"          %% "scala-xml"         % "1.0.5",
  "org.jsoup"                        % "jsoup"             % "1.8.1",
  "org.hjson"                        % "hjson"             % "1.1.2",
  "com.typesafe.play"               %% "play-json"         % "2.4.6",
  "com.googlecode.juniversalchardet" % "juniversalchardet" % "1.0.3",
  "org.scalatest"                   %% "scalatest"         % "2.2.6" % "test"
)

enablePlugins(JmhPlugin)

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)
    