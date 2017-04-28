name := "AuthServer"

version := "1.0"

scalaVersion := "2.11.7"


resolvers += "jitpack" at "https://jitpack.io"


libraryDependencies ++= Seq(

  "com.typesafe" % "config" % "1.3.1",

  "com.typesafe.akka" % "akka-http_2.11" % "10.0.5",

  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.5",

  "com.typesafe.akka" % "akka-http-testkit_2.11" % "10.0.5",

  "com.pauldijou" %% "jwt-core" % "0.12.1",

  "org.json4s" % "json4s-jackson_2.11" % "3.5.1",

  "com.github.dasbipulkumar" % "AkkaHttpJwtMicroserviceAuthDirective" % "master-SNAPSHOT"

)