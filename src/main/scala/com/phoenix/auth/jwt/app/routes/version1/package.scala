package com.imaginea.auth.jwt.app.routes

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives

/**
  * Created by bipulk on 4/26/17.
  */
package object version1 extends Directives {

  val route = pathPrefix("v1") {
    (pathEnd | pathSingleSlash) {
      get {
        complete {

          HttpEntity(ContentTypes.`text/html(UTF-8)`, response)

        }
      }
    } ~
      secured.route ~
      unsecured.route
  }


  val response = "<H1>Welcome to Auth Server Version 1 Api</H1>" + "<br/>" +
    "<a href=\"secured/\">Version 1 Secured Apis</a>" + "<br/>" +
    "<a href=\"unsecured/\">Version 1 Unecured Apis</a>" + "<br/>"
}
