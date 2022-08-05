package com.rentalproject.rentalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Rent {
    private int id;
    private String startDate;
    private String endDate;
    private double kilometers;
    private String personCNP;
    private String vehicleRegistrationNumber;

    public Rent(int id, String startDate, String endDate, double kilometers, String personCNP, String vehicleRegistrationNumber) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.kilometers = kilometers;
        this.personCNP = personCNP;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public Rent() {
        this.id = 0;
        this.startDate = "";
        this.endDate = "";
        this.kilometers = 0;
        this.personCNP = "";
        this.vehicleRegistrationNumber = "";
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getKilometers() {
        return kilometers;
    }

    public String getPersonCNP() {
        return personCNP;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public void setPersonCNP(String personCNP) {
        this.personCNP = personCNP;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }
    public void DBInsertInto() throws SQLException
    {
        if (DBClass.connection())
        {
            Statement statement = DBClass.conn.createStatement();
            String sql_statement = "insert into rentaldata(startdate,enddate,kilometers,idClients,idVehicles) ";
            try {
                Scanner cin = new Scanner(new File("inchirieri.txt"));
                Rental rental = new Rental();
                rental.readInputFiles("vehicles.txt", "persoane.txt");
                while (cin.hasNextLine())
                {
                    String line = cin.nextLine();
                    int indexPersons = 0;
                    int indexVehicle = 0;
                    for (int i = 0; i < rental.getPersons().size(); i++)
                    {
                        if (rental.getPersons().get(i).getCNP().equals(line.split(",")[3].replace(" ","")))
                        {
                            indexPersons = i + 4;
                            break;
                        }
                    }
                    for (int i = 0; i < rental.getVehicles().size(); i++)
                    {
                        if (rental.getVehicles().get(i).getRegistrationNumber().equals(line.split(",")[4].replace(" ","")))
                        {
                            indexVehicle = i + 1;
                            break;
                        }
                    }
                    String startdate = line.split(",")[0].replace(" ", "");
                    String enddate = line.split(",")[1].replace(" ", "");
                    String kilometers = line.split(",")[2].replace(" ", "");

                    statement.executeUpdate(sql_statement + "values('" + startdate + "','" + enddate + "','" + kilometers + "','" + indexPersons + "','" + indexVehicle + "');");
                }
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}
