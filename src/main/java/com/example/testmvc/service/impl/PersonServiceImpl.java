package com.example.testmvc.service.impl;

import com.example.testmvc.controller.dto.City;
import com.example.testmvc.controller.dto.Person;
import com.example.testmvc.exceptions.DuplicatePersonException;
import com.example.testmvc.exceptions.PersonNotFoundException;
import com.example.testmvc.service.PersonService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
public class PersonServiceImpl implements PersonService {

    //static List<Person> personList = new ArrayList<>();
    static ArrayList<Person> personList = getPersonList();


    @Override
    public ArrayList<Person> getPerson(Integer id){
        if(id != null)
        {
            ArrayList<Person> personListById = new ArrayList<>();
            Person person;
            person = personList
                    .stream()
                    .filter(c -> (c.getId() == id))
                    .findFirst()
                    .orElseThrow(() -> new PersonNotFoundException("Person with " + id + " doesn't exist."));
            personListById.add(person);
            return personListById;
        }
        else
            return personList;
    }

    @Override
    public Person getPersonWithCity(Integer id) {
        switch (id) {
            case 1: return new Person(id, "Dima", new City(1, "Saint-Petersburg", 4800000));
            case 2: return new Person(id, "Spartak", new City(2, "Moscow", 12000000));
        }
        throw new PersonNotFoundException("Person not found!");
        //return null;
    }

    @Override
    public String deletePerson(Integer id){
        return "Person with id " + id + " deleted.";
    }

    @Override
    public String nameToUpperCase(String name){
        return name.toUpperCase();
    }

    @Override
    public ArrayList<Person> addPersonToList(Person person) {
        if (personList.contains(person))
            throw new DuplicatePersonException("Person already exists.");
        personList.add(person);

        return personList;
    }

    private static ArrayList<Person> getPersonList() {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Dima", CityServiceImpl.cityList.get(0)));
        personList.add(new Person(2, "Spartak", CityServiceImpl.cityList.get(1)));
        return personList;
    }
}
