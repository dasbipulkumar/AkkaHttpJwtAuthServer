package com.imaginea.auth.jwt.app.routes.version1

import com.imaginea.auth.jwt.app.routes.version1.unsecured.auth.AuthRoutes

/**
  * Created by bipulk on 4/26/17.
  */
package object unsecured {

  val route = pathPrefix("unsecured") {
    (pathEnd | pathSingleSlash) {
      get {
        complete {
          "Welcome to Auth Server Unsecured Api Version 1"
        }
      }
    } ~ AuthRoutes.route
  }

}
