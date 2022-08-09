package com.rentalproject.rentalproject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RentalMethods {
    ArrayList<String> showHistoryOfRentalVehiclesAndTheirClient() throws SQLException;
    boolean rentAVehicle() throws SQLException;
    ArrayList<String> viewTheRentedVehiclesOfASpecificUser(String CNP) throws SQLException;
}
