package com.example.testmvc.controller;

import com.example.testmvc.controller.dto.Person;
import com.example.testmvc.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class PersonController {

    //@Qualifier("PersonServiceAnotherImpl") как использовать?
    private PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public ArrayList<Person> getPerson(@RequestParam(value = "id", required = false) Integer id){
        return personService.getPerson(id);
    }

    @GetMapping("/personWithCity/{id}")
    public Person getPersonWithCity(@PathVariable Integer id){
        //return ResponseEntity.ok().body(personService.getPersonWithCity(id));
        return personService.getPersonWithCity(id);
    }

    @GetMapping("/status")
    public HttpStatus getStatus(){
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/id")
    public Integer getId(){
        return 1;
    }

    //post name -> заглавные буквы
    @PostMapping("/nameToUpperCase/{name}")
    //@Operation(summary = "Удаление")
    public String nameToUpperCase(@PathVariable String name){
        return personService.nameToUpperCase(name);
    }

    //post json body со всеми полями сущности, создать list person
    // @Valid @RequestBody Person dto
    @PostMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Person> getPersonJSON(@RequestBody Person person) {
        return personService.addPersonToList(person);
    }

    @DeleteMapping("/person/{id}")
    //@Operation(summary = "Удаление")
    public String deletePerson(@PathVariable Integer id){
        return personService.deletePerson(id);
    }


    // удаление из листа
    // создать адрес
    // изменение person/city
}
