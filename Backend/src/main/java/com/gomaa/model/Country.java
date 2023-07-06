package com.ahmed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
//add jsonignor
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private Set<State> states;
}
