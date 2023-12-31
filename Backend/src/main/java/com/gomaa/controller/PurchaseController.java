package com.ahmed.controller;

import com.ahmed.dto.PurchaseRequest;
import com.ahmed.dto.PurchaseResponse;
import com.ahmed.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// http://localhost:8080
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/buy")
// http://localhost:8080/api/buy
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    // http://localhost:8080/api/buy/purchase
    @PostMapping("/purchase")
    public PurchaseResponse addRequestOrder(@RequestBody PurchaseRequest purchaseRequest){
        System.out.println(purchaseRequest.getItems().size());
        return purchaseService.addRequestOrder(purchaseRequest);
    }
}
