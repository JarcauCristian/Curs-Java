package com.rentalproject.rentalproject;

import java.util.ArrayList;

public interface RentalMethods {
    ArrayList<String> showHistoryOfRentalVehiclesAndTheirClient();
    boolean rentAVehicle();
    ArrayList<String> viewTheRentedVehiclesOfASpecificUser(String CNP);
}
