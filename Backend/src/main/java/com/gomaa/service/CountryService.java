package com.ahmed.service;

import com.ahmed.deo.CountryRepository;
import com.ahmed.model.Country;
import com.ahmed.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country>getAllCountry(){
        return this.countryRepository.findAll();
    }


}
