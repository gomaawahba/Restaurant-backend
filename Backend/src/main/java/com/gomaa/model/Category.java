package com.ahmed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Data

@Entity
@Table(name="category")
public class Category extends BaseEntity{
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Order>orders;
    @Column(name="data_create")
    @CreationTimestamp
    private Date datecreate;
    @Column(name="data_update")
    @UpdateTimestamp
    private Date dateupdate;
    // logo: string;

    @Column(name = "logo")

    private String logo;



}
