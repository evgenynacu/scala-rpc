import sbt._

object Dependencies {
  val fullScalaVersion = "2.13.10"

  val slf4jApi = "org.slf4j" % "slf4j-api" % "1.7.32"
  val reactor = "io.projectreactor" % "reactor-core" % "3.4.24"
  val reactorNetty = "io.projectreactor.netty" % "reactor-netty" % "1.0.24"
  val cats = "org.typelevel" %% "cats-core" % "2.1.1"
  val springWebFlux = "org.springframework" % "spring-webflux" % "5.3.23"
  val scalajHttp = "org.scalaj" %% "scalaj-http" % "2.4.2"
  val sttp = "com.softwaremill.sttp" %% "core" % "1.7.2"

  val jackson = "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.4.2"
  val jacksonScala = "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.4"

  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
  val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.3"
  val mockito = "org.mockito" % "mockito-all" % "1.10.19"
  val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.2.11"

  val bouncyCastle = "org.bouncycastle" % "bcprov-jdk15on" % "1.62"
  val junit = "junit" % "junit" % "4.11"

  val freemarker = "org.freemarker" % "freemarker" % "2.3.23"
  val beanutils = "commons-beanutils" % "commons-beanutils" % "1.9.3"
}
