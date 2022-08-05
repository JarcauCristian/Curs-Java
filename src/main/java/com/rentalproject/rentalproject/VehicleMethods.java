package com.rentalproject.rentalproject;

import java.util.ArrayList;

public interface VehicleMethods {
    ArrayList<Vehicle> viewVehicleOrderByManufactureYear();
    ArrayList<Vehicle> searchAVehicleByType(String type);
}
