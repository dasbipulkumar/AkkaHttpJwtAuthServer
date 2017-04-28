package com.imaginea.auth.jwt.app.routes.version1

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives
import com.imaginea.auth.jwt.app.routes.version1.secured.auth.AuthRoutes
import com.phoenix.akka.http.auth.jwt.models.JsonSupport
import com.phoenix.akka.http.auth.jwt.customdirectives.Authentication._

/**
  * Created by bipulk on 4/26/17.
  */
package object secured extends Directives with JsonSupport {

  val route = (pathPrefix("secured")) {

    import com.typesafe.config.ConfigFactory
    val conf = ConfigFactory.load()

    (pathEnd | pathSingleSlash) {
      get {
        complete {
          HttpEntity(ContentTypes.`text/html(UTF-8)`, response)
        }
      }
    } ~
      authenticate(conf.getString("jwt.secret-key")) { token =>
        AuthRoutes.route
      }

  }

  val response = "<H1>Welcome to Auth Server Secured Api Version 1</H1>" + "<br/>"

}
