package service

import model.Vehicle

class VehicleService {

  def getVehicle(regNum:String) = {
    val vehicle = Vehicle.findByReg(regNum)
    println(s" DB vehicle : $vehicle")
    vehicle
  }
}
