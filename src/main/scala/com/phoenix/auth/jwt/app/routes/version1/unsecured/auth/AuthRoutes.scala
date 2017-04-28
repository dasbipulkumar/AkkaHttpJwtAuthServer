package com.imaginea.auth.jwt.app.routes.version1.unsecured.auth

import akka.http.scaladsl.model.StatusCodes.Unauthorized
import akka.http.scaladsl.server.Directives
import com.phoenix.akka.http.auth.jwt.models.{JsonSupport, JwtModel, LoginRequest, LoginResponse}
import com.phoenix.akka.http.auth.jwt.{JwtUtils, SymetricKeyJwtService}
import spray.json._

/**
  * Created by bipulk on 4/26/17.
  */


object AuthRoutes extends Directives with JsonSupport {

  import com.typesafe.config.ConfigFactory

  private val conf = ConfigFactory.load()


  val route = (pathPrefix("auth" / "login")) {

    (pathEnd | pathSingleSlash) {
      post {
        entity(as[LoginRequest]) { loginRequest =>

          //todo
          //add user authentication call to mongo service
          if (true) {

            complete(LoginResponse(JwtUtils.encode(SymetricKeyJwtService)(JwtModel(loginRequest.username,
              loginRequest.usertype, System.currentTimeMillis(), System.currentTimeMillis() + (conf.getInt("jwt.session-timeout") * 1000), List.empty),
                  conf.getString("jwt.secret-key"))))

          } else {

            complete(Unauthorized, JsObject(Map("status" -> JsString("Invalid Credentials"))))

          }
        }
      }
    }
  }

}

