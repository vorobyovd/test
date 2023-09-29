package com.example.testmvc.controller.dto;

import javax.validation.constraints.NotNull;

public class City {
    private int id;

    @NotNull
    private String name;
    private int population;
    private Address address;

    public City(){}

    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public City(int id, String name, int population, Address address) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }
}
