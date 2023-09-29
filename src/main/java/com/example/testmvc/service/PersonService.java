package com.example.testmvc.service;

import com.example.testmvc.controller.dto.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PersonService {
    public ArrayList<Person> getPerson(Integer id);
    public Person getPersonWithCity (Integer id);
    public String deletePerson(Integer id);
    public String nameToUpperCase(String name);
    public ArrayList<Person> addPersonToList(Person person);

}
