package com.ahmed.controller;

import com.ahmed.model.State;
import com.ahmed.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class StateController {
    private StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }
    // http://localhost:8080/api/states
    @GetMapping("/states")
    public List<State>getallstate(){
        return this.stateService.getAllStat();
    }
    //http://localhost:8080/api/statescode?code={value}
    @GetMapping("/statescode")
    public List<State> getStatesByCode(@RequestParam String code){
        return stateService.getStatesByCountryCode(code);
    }
}
