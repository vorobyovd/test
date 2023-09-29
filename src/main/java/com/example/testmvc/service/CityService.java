package com.example.testmvc.service;

import com.example.testmvc.controller.dto.City;

import com.example.testmvc.controller.dto.Person;
import com.example.testmvc.model.db.CityEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CityService {
    public ArrayList<City> getCity(Integer id);
    public ArrayList<CityEntity> getCityEntity(Integer id);
    public String deleteCity(Integer id);
    public String deleteCityEntity(Integer id);
    public ArrayList<City> addCityToList(City city);
}


