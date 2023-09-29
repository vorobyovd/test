package com.example.testmvc.service.impl;

import com.example.testmvc.controller.dto.City;
import com.example.testmvc.controller.dto.Person;
import com.example.testmvc.exceptions.PersonNotFoundException;
import com.example.testmvc.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonServiceAnotherImpl implements PersonService {

    @Override
    public ArrayList<Person> getPerson(Integer id){
        return null;
    }

    @Override
    public Person getPersonWithCity(Integer id) {
    return null;
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
        return null;
    }
}
