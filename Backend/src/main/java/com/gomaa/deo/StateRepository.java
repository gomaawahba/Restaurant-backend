package com.ahmed.deo;

import com.ahmed.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State,Long> {
    //public List<State> findByCountryCode(String code);
    public List<State> findByCountryCode(String Code);
//    public List<State> findByCountryCode(String Code);
}
