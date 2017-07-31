lazy val hello = taskKey[Unit]("hello world")

lazy val root = (project in file(".")).settings(
  name := "sbt-sandbox",
  version := "1.0",
  scalaVersion := "2.11.8",
  hello := { println("hello!") }
)

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest" % "2.2.6" % "test"
)

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)