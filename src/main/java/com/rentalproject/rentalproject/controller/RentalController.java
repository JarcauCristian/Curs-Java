package com.rentalproject.rentalproject.controller;

import com.rentalproject.rentalproject.Rental;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;


@Controller
public class RentalController {

    private static Rental rental = new Rental();

    @GetMapping("/rental-orders")
    public String orders(Model model)
    {
        rental.readInputFiles("vehicles.txt", "persoane.txt");
        model.addAttribute("orders",rental.viewVehicleOrderByManufactureYear());
        return "rental-orders";
    }

    @GetMapping("/all-orders")
    public String all_orders(Model model)
    {
        try {
            model.addAttribute("allvandp",rental.showHistoryOfRentalVehiclesAndTheirClient());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "all-rented-vehicles";
    }

    @GetMapping("/vehicle-by-type")
    public String vehicle_by_type(@RequestParam(required = false) String type, Model model)
    {
        rental.readInputFiles("vehicles.txt", "persoane.txt");
        model.addAttribute("vbytypes", rental.searchAVehicleByType(type));
        return "vehicle-by-type";
    }

    @GetMapping("/rented-specific-user")
    public String rented_specific_user(@RequestParam(required = false) String CNP, Model model)
    {
        rental.readInputFiles("vehicles.txt", "persoane.txt");
        try {
            model.addAttribute("spuser", rental.viewTheRentedVehiclesOfASpecificUser(CNP));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "rented-specific-user";
    }

}
