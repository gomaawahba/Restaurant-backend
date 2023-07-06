package com.ahmed.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address extends BaseEntity{
    @Column(name = "data_create")
    @CreationTimestamp
    @Lob
    private Date dataCreate;

    @Column(name = "data_update")
    @UpdateTimestamp
    @Lob
    private Date dataUpdate;
    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private RequestOrder requestOrder;


}
