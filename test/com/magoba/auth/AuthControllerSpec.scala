package com.magoba.auth

import java.util.concurrent.TimeUnit

import org.scalatestplus.play.{OneServerPerSuite, PlaySpec}
import play.api.libs.ws.WS
import play.api.mvc.Results
import play.api.test.Helpers.await
import play.api.http.Status._
import akka.util.Timeout

import scala.concurrent.duration.Duration

class AuthControllerSpec extends PlaySpec with Results with OneServerPerSuite {

  implicit val timeout: Timeout = Duration(5, TimeUnit.SECONDS)
  override lazy val port = 9000

  "Auth controller" should {
    "return ok" in {

      val response = await(WS.url("http://localhost:9000/ok").get())

      response.status mustBe OK
    }
  }

}
