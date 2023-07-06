package com.ahmed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order extends BaseEntity{
    /*
    *  id: number;
  name: string;
  data_create: Date;
  data_update: Date;
  description: string;
  img: string;
  price: number;*/

    @Column(name = "name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="image")
    private String img;
    @Column(name="description")
    @Lob
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_category")
    @JsonIgnore
    private Category category;
    @Column(name="data_create")
    @CreationTimestamp
    private Date datecreate;
    @Column(name="data_update")
    @UpdateTimestamp
    private Date dateupdate;

}
