package com.example.testmvc.controller.dto;


//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;


import javax.validation.constraints.NotNull;

public class Person {

    //@NotNull
    //@Parameter(description = "Id", required = true)
    private Integer id;

    @NotNull
    private String name;
    private City city;

    public Person(){}

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    //equlas переопределить
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        return Integer.compare(id, person.id) == 0 && name.equals(person.name);
    }
}
