lazy val root = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)

name := "learnScalaJs"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

scalaJSStage in Global := FastOptStage

persistLauncher := true

//persistLauncher in Test := false

scalacOptions ++= Seq("-deprecation", "-feature", "-Xlint")

licenses +=("MIT", url("http://opensource.org/licenses/MIT"))

//jsDependencies += RuntimeDOM
jsDependencies in Test += RuntimeDOM

jsDependencies +=
  "org.webjars" % "jquery" % "2.1.3" / "2.1.3/jquery.js"

//skip in packageJSDependencies := false

libraryDependencies ++= Seq("com.lihaoyi" %%% "utest" % "0.3.0" % "test")
testFrameworks += new TestFramework("utest.runner.Framework")


libraryDependencies ++= Seq(
  "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "com.thoughtworks.binding" %%% "dom" % "latest.release",
  "com.github.japgolly.scalacss" %%% "core" % "0.5.0"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
