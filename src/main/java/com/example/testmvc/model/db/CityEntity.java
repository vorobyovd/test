package com.example.testmvc.model.db;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "City")
public class CityEntity {

    private int id;
    private String name;
    private int population;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CITY_SEQ")
    @SequenceGenerator(name = "CITY_SEQ", sequenceName = "CITY_SEQ", allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
