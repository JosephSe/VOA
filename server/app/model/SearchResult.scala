package model

import play.api.libs.json.{JsValue, Json}

case class SearchResult(regNumId: String, make: String, tax: String, mot: String, dateOfReg: String, mfg: String, cc: String, emissions: String, fuelType: String, color: String, typ: String, wheelPlan: String, weight: String) {
  def this(vehicle: Vehicle) = this(vehicle.regNumId, vehicle.make, vehicle.tax, vehicle.mot, vehicle.dateOfReg, vehicle.mfg, vehicle.cc, vehicle.emissions, vehicle.fuelType, vehicle.color, vehicle.typ, vehicle.wheelPlan, vehicle.weight)
}

object SearchResult {
  def convertToJsonOrig(v: Vehicle): JsValue = {
    Json.toJson(
        Map("regNum" -> v.regNumId,"make" -> v.make,"tax" -> v.tax,"mot" -> v.mot,"dateOfReg" -> v.dateOfReg,"mfg" -> v.mfg,"cc" -> v.cc,"emissions" -> v.emissions,"fuelType" -> v.fuelType,"color" -> v.color,"typ" -> v.typ,"wheelPlan" -> v.wheelPlan,"weight" -> v.weight)
    )
  }
  def apply(vehicle: Vehicle) = new SearchResult(vehicle)
}
