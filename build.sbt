name := "sbt-sandbox"

version := "1.0"

scalaVersion := "2.11.8"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

libraryDependencies ++= Seq(
  "io.frees" %% "freestyle" % "0.2.0"
)

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)
    