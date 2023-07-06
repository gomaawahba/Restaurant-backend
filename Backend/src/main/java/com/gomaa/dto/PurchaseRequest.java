package com.ahmed.dto;

import com.ahmed.model.Address;
import com.ahmed.model.Client;
import com.ahmed.model.Item;
import com.ahmed.model.RequestOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {

    private Client client;
    private RequestOrder requestOrder;
    private List<Item> items;
    private Address fromAddress;
    private Address toAddress;

}