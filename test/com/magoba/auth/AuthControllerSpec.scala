package com.magoba.auth

import java.util.concurrent.TimeUnit

import org.scalatestplus.play.{OneServerPerSuite, PlaySpec}
import play.api.libs.ws.WS
import play.api.mvc.Results
import play.api.test.Helpers.await
import play.api.http.Status._
import akka.util.Timeout
import org.joda.time.DateTime
import org.magoba.auth.controller.LoginDetails
import play.api.libs.json.Json
import scalikejdbc.{AutoSession, _}

import scala.concurrent.duration.Duration

class AuthControllerSpec extends PlaySpec with Results with OneServerPerSuite {

  implicit val timeout: Timeout = Duration(50, TimeUnit.SECONDS)
  override lazy val port = 9000

  "Auth controller" should {
    "return ok" in {

      createUser()

      val loginDetails = LoginDetails("test", "test")

      val response = await(WS.url("http://localhost:9000/login").post(Json.toJson(loginDetails)))

      response.status mustBe OK
    }
  }


  def createUser(): Unit ={
    val now = DateTime.now()
    sql"insert into user(id, name, password, last_login) values ('test','Test test','test',${now})".update.apply()(AutoSession)
  }

}
