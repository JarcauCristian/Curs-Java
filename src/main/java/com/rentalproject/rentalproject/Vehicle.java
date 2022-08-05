package com.rentalproject.rentalproject;

import java.util.Objects;

enum Type{
    SCOOTER,
    RULOTA,
    MASINA
};
public class Vehicle {
    private String registrationNumber;
    private Type type;
    private String brand;
    private String color;
    private Integer manufactureYear;

    public Vehicle(String registrationNumber, String type, String brand, Integer manufactureYear, String color) {
        this.registrationNumber = registrationNumber;
        switch (type)
        {
            case "SCOOTER":
                this.type = Type.SCOOTER;
                break;
            case "RULOTA":
                this.type = Type.RULOTA;
                break;
            case "MASINA":
                this.type = Type.MASINA;
                break;
        }
        this.brand = brand;
        this.color = color;
        this.manufactureYear = manufactureYear;
    }

    public Vehicle() {
        this.brand = "";
        this.color = "";
        this.manufactureYear = 0;
        this.registrationNumber = "";
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Type getType()
    {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", manufactureYear=" + manufactureYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return registrationNumber.equals(vehicle.registrationNumber) && brand.equals(vehicle.brand) && color.equals(vehicle.color) && manufactureYear.equals(vehicle.manufactureYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, brand, color, manufactureYear);
    }
}
