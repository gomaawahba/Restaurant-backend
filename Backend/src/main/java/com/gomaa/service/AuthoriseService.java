package com.ahmed.service;

import com.ahmed.deo.AuthoritiesRepository;
import com.ahmed.model.Authorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthoriseService {
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public AuthoriseService(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }
    /*private Authorities getAuthorities(){
        return AuthoritiesRepository.findAll();
    }*/

    @Transactional(readOnly = true)
    public List<Authorities> getAuthorities(){
        return authoritiesRepository.findAll();
    }


}
