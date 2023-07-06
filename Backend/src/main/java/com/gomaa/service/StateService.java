package com.ahmed.service;

import com.ahmed.deo.StateRepository;
import com.ahmed.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    private StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }
    public List<State>getAllStat(){
        return this.stateRepository.findAll();
    }
    public List<State> getStatesByCountryCode(String code){
        return stateRepository.findByCountryCode(code);
    }
}
