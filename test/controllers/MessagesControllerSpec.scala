package controllers

import org.specs2.matcher.JsonMatchers
import org.specs2.mutable.Specification
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}

class MessagesControllerSpec extends Specification with JsonMatchers {
  "MessagesController" should {

    "respond with the message sent" in new WithApplication {
      val body = Json.parse(
        """{
          "message": "Foo message"
         }"""
      )
      val Some(result) = route(FakeRequest(POST, "/messages").withJsonBody(body))

      status(result) must equalTo(OK)
      contentAsString(result) must /("message" -> "Foo message")
    }
  }
}
