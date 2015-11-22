package controllers

import javax.inject.Inject

import play.api._
import play.api.mvc._
import service.DataLoaderService

class Application extends Controller {

  def index = Action {
    Ok("Your new application is ready.")
  }

}
