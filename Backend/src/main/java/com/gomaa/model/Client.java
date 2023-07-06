package com.ahmed.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client")

public class Client extends BaseEntity {
    @Column(name = "data_create")
    @CreationTimestamp
    @Lob
    private Date dataCreate;

    @Column(name = "data_update")
    @UpdateTimestamp
    @Lob
    private Date dataUpdate;
    @Column(name = "name")
    private String name;  // Egypt
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<RequestOrder> requestOrders = new HashSet<>();

    public void addRequestOrder(RequestOrder requestOrder){
        requestOrders.add(requestOrder);
        requestOrder.setClient(this);

    }


}
