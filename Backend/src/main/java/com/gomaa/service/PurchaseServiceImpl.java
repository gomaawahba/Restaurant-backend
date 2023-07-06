package com.ahmed.service;

import com.ahmed.deo.ClientRepository;
import com.ahmed.dto.PurchaseRequest;
import com.ahmed.dto.PurchaseResponse;
import com.ahmed.model.Item;
import com.ahmed.model.RequestOrder;
import com.ahmed.util.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    private ClientRepository clientRepository;

    @Autowired
    public PurchaseServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse addRequestOrder(PurchaseRequest purchases) {
        /* #1 */
        RequestOrder requestOrder = purchases.getRequestOrder();
        /* #2 */
        String myCode = UserCode.getCode();
        requestOrder.setCode(myCode);

        /* #3 */
        List<Item> items = purchases.getItems();
        items.forEach(item -> requestOrder.addItem(item));

        /* #4 */
        requestOrder.setFromAddress(purchases.getFromAddress());
        requestOrder.setToAddress(purchases.getToAddress());

        /* #5 */
        purchases.getClient().addRequestOrder(requestOrder);

        clientRepository.save(purchases.getClient());

        return new PurchaseResponse(purchases.getClient().getName(),myCode);
    }


}
