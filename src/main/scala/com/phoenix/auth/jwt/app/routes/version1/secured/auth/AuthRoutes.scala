package com.imaginea.auth.jwt.app.routes.version1.secured.auth

import akka.http.scaladsl.server.Directives
import com.phoenix.akka.http.auth.jwt.models.{JsonSupport, LoginResponse}
import spray.json.DefaultJsonProtocol
import com.phoenix.akka.http.auth.jwt.customdirectives.Authentication._

/**
  * Created by bipulk on 4/26/17.
  */
object AuthRoutes extends Directives with JsonSupport with DefaultJsonProtocol {

  val route = pathPrefix("auth" / "validateAndUpdateToken") {
    (pathEnd | pathSingleSlash) {
      get {

        import com.typesafe.config.ConfigFactory
        val conf = ConfigFactory.load()

        updateJwtToken(conf.getInt("jwt.session-timeout"), conf.getString("jwt.secret-key")) { newToken =>

          complete(LoginResponse(newToken))

        }

      }
    }
  }

}
