package com.example.testmvc.controller.dto;

public class Address {
    private String zipCode;
    private String house;
    private String building;
    private String street;
    private String apartment;

    public Address(String zipCode, String house, String building, String street, String apartment) {
        this.zipCode = zipCode;
        this.house = house;
        this.building = building;
        this.street = street;
        this.apartment = apartment;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getHouse() {
        return house;
    }

    public String getBuilding() {
        return building;
    }

    public String getStreet() {
        return street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
