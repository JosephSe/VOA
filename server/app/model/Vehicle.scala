package model

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db._

import scala.language.postfixOps

case class Vehicle(regNumId: String, make: String, tax: String, mot: String, dateOfReg: String, mfg: String,
                   cc: String, emissions: String, fuelType: String, color: String, typ: String, wheelPlan: String, weight: String)

object Vehicle {

  /**
   * Parse a Company from a ResultSet
   */
  val simple = {
    get[String]("vehicle.regNumId") ~
      get[String]("vehicle.make") ~
      get[String]("vehicle.tax") ~
      get[String]("vehicle.mot") ~
      get[String]("vehicle.dateOfReg") ~
      get[String]("vehicle.mfg") ~
      get[String]("vehicle.cc") ~
      get[String]("vehicle.emissions") ~
      get[String]("vehicle.fuelType") ~
      get[String]("vehicle.color") ~
      get[String]("vehicle.typ") ~
      get[String]("vehicle.wheelPlan") ~
      get[String]("vehicle.weight") map {
      case regNumId ~ make ~ tax ~ mot ~ dateOfReg ~ mfg ~ cc ~ emissions ~ fuelType ~ color ~ typ ~ wheelPlan ~ weight => Vehicle(regNumId, make, tax, mot, dateOfReg, mfg, cc, emissions, fuelType, color, typ, wheelPlan, weight)
    }
  }

  /**
   * Retrieve a Vehicle details from the regNumId.
   */
  def findByReg(regNumId: String): Option[Vehicle] = {
    DB.withConnection { implicit connection =>
      SQL("select * from vehicle where regNumId = {regNumId}").on('regNumId -> regNumId)
        .as(Vehicle.simple.singleOpt)
    }
  }
}
