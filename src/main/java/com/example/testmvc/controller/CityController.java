package com.example.testmvc.controller;

import com.example.testmvc.controller.dto.City;
import com.example.testmvc.controller.dto.Person;
import com.example.testmvc.model.db.CityEntity;
import com.example.testmvc.service.CityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city")
    public ArrayList<City> getCity(@RequestParam(value = "id", required = false) Integer id){
        return cityService.getCity(id);
    }

    @GetMapping("/cityEntity")
    public ArrayList<CityEntity> getCityEntity(@RequestParam(value = "id", required = false) Integer id){
        return cityService.getCityEntity(id);
    }

    @PostMapping(value = "/city", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<City> addCity(@RequestBody City city) {
        return cityService.addCityToList(city);
    }

    @DeleteMapping("/city/{id}")
    public String deleteCity(@PathVariable Integer id){
        return cityService.deleteCity(id);
    }

    @DeleteMapping("/cityEntity/{id}")
    public String deleteCityEntity(@PathVariable Integer id){
        return cityService.deleteCityEntity(id);
    }

}
