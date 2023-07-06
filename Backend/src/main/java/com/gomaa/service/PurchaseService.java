package com.ahmed.service;

import com.ahmed.dto.PurchaseRequest;
import com.ahmed.dto.PurchaseResponse;

public interface PurchaseService {
    public PurchaseResponse addRequestOrder(PurchaseRequest purchases);
}
