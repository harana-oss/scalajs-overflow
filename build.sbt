lazy val commonSettings = Seq(
  name := "scalajs-overflow",
  version := "1.0",
  scalaVersion := "2.12.8",
  organization := "com.harana",
  target := file(baseDirectory.value + "/../target") / name.value,
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots"),
    "Typed" at "https://dl.bintray.com/oyvindberg/ScalablyTyped"
  ),
)

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

lazy val js = (project in file("js"))
  .settings(
    commonSettings,
    scalaJSUseMainModuleInitializer := true,
    scalaJSOptimizerOptions in fastOptJS ~= { _.withDisableOptimizer(true) },
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    libraryDependencies ++= Seq(
      "me.shadaj" %%% "slinky-core" % "0.5.2",
      "me.shadaj" %%% "slinky-web" % "0.5.2",
      "org.scalablytyped" %%% "std" % "3.3-6e4388"
    ),
  )
  .enablePlugins(ScalaJSPlugin)

