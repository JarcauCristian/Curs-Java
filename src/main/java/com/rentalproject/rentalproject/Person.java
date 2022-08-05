package com.rentalproject.rentalproject;

import java.util.Date;

public class Person {
    private String CNP;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private Integer yearOfDriverLicenseEmited;

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String CNP, String firstName, String lastName, String gender, Integer yearOfDriverLicenseEmited) {
        if(CNP.length() == 13)
        {
            this.CNP = CNP;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = "";
        this.gender = gender;
        this.yearOfDriverLicenseEmited = yearOfDriverLicenseEmited;
    }

    public Person() {
        this.CNP = "";
        this.dateOfBirth = "";
        this.firstName = "";
        this.lastName = "";
        this.gender = "";
        this.yearOfDriverLicenseEmited = 1900;
    }

    public String getCNP() {
        return CNP;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public Integer getYearOfDriverLicenseEmited() {
        return yearOfDriverLicenseEmited;
    }
}
