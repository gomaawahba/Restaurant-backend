package com.ahmed.controller;

import com.ahmed.model.Country;
import com.ahmed.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// http://localhost:8080/api
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    // http://localhost:8080/api/countries
    @GetMapping("/countries")
    public List<Country>getallCountry(){
        return this.countryService.getAllCountry();
    }
}
