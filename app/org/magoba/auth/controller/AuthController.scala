package org.magoba.auth.controller

import javax.inject.Inject

import org.magoba.auth.service.UserService
import play.api.Configuration
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json.{JsResult, JsValue, Json}
import play.api.mvc.{Action, Controller, Request}

class AuthController @Inject()(val messagesApi: MessagesApi, configuration: Configuration, userService: UserService) extends Controller with I18nSupport {

  def login = Action(parse.json) { implicit request: Request[JsValue] =>
    val loginDetails: JsResult[LoginDetails] = Json.fromJson(request.body)(LoginDetails.format)//remove this
    loginDetails
      .map(loginDetails => userService.login(loginDetails.login, loginDetails.password)
        .map(_ => Ok).getOrElse(Unauthorized)).getOrElse(BadRequest)
  }

}

case class LoginDetails(login: String, password: String)

object LoginDetails{
  implicit val format = Json.format[LoginDetails]
}
