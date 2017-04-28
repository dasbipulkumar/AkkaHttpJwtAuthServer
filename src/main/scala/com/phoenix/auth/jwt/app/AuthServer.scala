package com.imaginea.auth.jwt.app

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.{ActorMaterializer, Materializer}

/**
  * Created by bipulk on 4/26/17.
  */
object AuthServer {

  val route: Route = routes.route

  def main(args: Array[String]): Unit = {

    import com.typesafe.config.ConfigFactory
    val conf = ConfigFactory.load()

    implicit val sys = ActorSystem("AuthServer")
    implicit val mat: Materializer = ActorMaterializer()

    Http().bindAndHandle(route, "localhost", conf.getInt("application.config.port"))

  }

}
