package com.imaginea.auth.jwt.app

import java.nio.charset.Charset

import akka.http.javadsl.model.HttpResponse
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives

/**
  * Created by bipulk on 4/26/17.
  */
package object routes extends Directives {

  val route = pathSingleSlash {
    get {
      complete {
        HttpEntity(ContentTypes.`text/html(UTF-8)`, response)
      }
    }
  } ~
    version1.route


  val response = "<H1>Welcome to Auth Server Api</H1>" + "<br/>" +
    "<a href=\"v1/\">Version 1 Apis</a>"
}
