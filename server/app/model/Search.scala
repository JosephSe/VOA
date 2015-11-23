package model

import play.api.libs.json.Json

case class VehicleSearch(regNum:String = "", make:String = "", v5c:String = "")

object VehicleSearch {
  implicit val vehicleSearch = Json.format[VehicleSearch]
}
