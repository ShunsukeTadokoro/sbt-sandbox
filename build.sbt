name := "sbt-sandbox"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalaz"                      %% "scalaz-core"       % "7.2.0",
  "org.scala-lang.modules"          %% "scala-xml"         % "1.0.5",
  "org.jsoup"                        % "jsoup"             % "1.8.1",
  "com.googlecode.juniversalchardet" % "juniversalchardet" % "1.0.3",
  "org.scalatest"                   %% "scalatest"         % "2.2.6" % "test"
)

enablePlugins(JmhPlugin)

    