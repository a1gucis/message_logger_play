package controllers

import java.text.SimpleDateFormat
import java.util.Calendar

import play.api.mvc.{Action, Controller}

object MessagesController extends Controller {

  def post = Action(parse.json) { request =>
    val tStamp = Calendar.getInstance.getTime
    val tStampStr = new SimpleDateFormat("kk:mm:ss").format(tStamp)
    println(s"${tStampStr} ${request.body}")
    Ok(request.body)
  }
}
