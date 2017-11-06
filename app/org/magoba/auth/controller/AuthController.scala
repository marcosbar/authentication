package org.magoba.auth.controller

import javax.inject.Inject

import play.api.Configuration
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

class AuthController @Inject()(val messagesApi: MessagesApi, configuration: Configuration) extends Controller with I18nSupport {

  def ok() = Action {
    Ok
  }

}
