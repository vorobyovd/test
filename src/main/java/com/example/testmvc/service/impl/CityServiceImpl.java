package com.example.testmvc.service.impl;

import com.example.testmvc.controller.dto.Address;
import com.example.testmvc.controller.dto.City;
import com.example.testmvc.exceptions.CityNotFoundException;
import com.example.testmvc.exceptions.DuplicateCityException;
import com.example.testmvc.model.db.CityEntity;
import com.example.testmvc.repository.db.CityEntityRepository;
import com.example.testmvc.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class CityServiceImpl implements CityService {

    public static ArrayList<City> cityList = getCityList();
    CityEntityRepository cityEntityRepository;

    public CityServiceImpl(CityEntityRepository cityEntityRepository) {
        this.cityEntityRepository = cityEntityRepository;
    }


    @Override
    public ArrayList<City>  getCity(Integer id){
        if(id != null)
        {
            ArrayList<City> cityListById = new ArrayList<>();
            City city;
            city = cityList
                    .stream()
                    .filter(c -> (c.getId() == id))
                            .findFirst()
                            .orElseThrow(() -> new CityNotFoundException("City with " + id + " doesn't exist."));
            cityListById.add(city);
            return cityListById;
        }
        else
            return cityList;
    }

    @Override
    public ArrayList<CityEntity> getCityEntity(Integer id) {
        ArrayList<CityEntity> cityListById = new ArrayList<>();
        CityEntity city = cityEntityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City with " + id + " doesn't exist."));
        cityListById.add(city);
        return cityListById;
    }

    @Override
    public String deleteCity(Integer id) {
        City city;
        city = cityList
                .stream()
                .filter(c -> (c.getId() == id))
                .findFirst()
                .orElseThrow(() -> new CityNotFoundException("City with " + id + " doesn't exist."));
        cityList.remove(city);
        return "City with id " + id + " deleted.";
    }

    @Override
    public String deleteCityEntity(Integer id) {
        if (cityEntityRepository.existsById(id)) {
            cityEntityRepository.deleteById(id);
            return "City with id " + id + " deleted.";
        }
        else throw new CityNotFoundException("City with " + id + " doesn't exist.");
    }

    private static ArrayList<City> getCityList() {
        ArrayList<City> cityList = new ArrayList<>();
        cityList.add(new City(1, "Saint-Petersburg", 4800000, new Address("198061", "10", "1", "Konnaya", "2")));
        cityList.add(new City(2, "Moscow", 12000000));
        cityList.add(new City(3, "Sochi", 900000));
        return cityList;
    }

    public ArrayList<City> addCityToList(City city){
        if (cityList.contains(city))
            throw new DuplicateCityException("City already exists.");
        cityList.add(city);

        return cityList;
    }
}
