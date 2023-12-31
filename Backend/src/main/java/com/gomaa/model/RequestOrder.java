package com.ahmed.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "request_order")

public class RequestOrder extends BaseEntity {
    @Column(name = "data_create")
    @CreationTimestamp
    @Lob
    private Date dataCreate;

    @Column(name = "data_update")
    @UpdateTimestamp
    @Lob
    private Date dataUpdate;
    @Column(name = "code")
    private String code;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "requestOrder")
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client = new Client();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_address_id")
    private Address toAddress = new Address();
    //,referencedColumnName = "id"
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_address_id",referencedColumnName = "id")
    private Address fromAddress = new Address();

    public void addItem(Item item){
        items.add(item);
        item.setRequestOrder(this);
    }




}
