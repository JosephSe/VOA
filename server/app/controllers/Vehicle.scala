package controllers

import javax.inject.Inject

import model.{SearchResult, VehicleSearch}
import play.api.libs.json.Json
import play.api.mvc._
import service.VehicleService

class Vehicle @Inject()(vehicleService: VehicleService) extends Controller {

  def search = Action { request =>
    val payload = request.body.asJson.get
    val vehicleSearch = payload.as[VehicleSearch]
    //    println(payload)
    val vehicle = vehicleService.getVehicle(vehicleSearch.regNum)
    if(vehicle.isDefined) Ok(SearchResult.convertToJsonOrig(vehicle.get))
    else Results.NoContent
  }

}
