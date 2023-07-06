package com.ahmed.service;

import com.ahmed.deo.OrderRepository;
import com.ahmed.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> getAllOrders( int page,int size){
        Pageable pageable=PageRequest.of(page, size);
        return this.orderRepository.findAll(pageable).getContent();
    }
    public List<Order>getAllOrdersByID(Long id,int page,int size){
        Pageable pageable=PageRequest.of(page, size);
        return this.orderRepository.findByCategoryId(id,pageable).getContent();
    }
    public List<Order>getAllOrdersBykey(String key,int page,int size){
        Pageable pageable=PageRequest.of(page, size);
        return this.orderRepository.findByNameContaining(key,pageable).getContent();
    }
    public Order getOrder(Long id){
        return  this.orderRepository.findById(id).get();

    }
    //get all size order
    public long getAllOrdersSize(){
        return orderRepository.count();
    }
    //get all size order by category id
    public long getOrdersByCategoryIdLength(Long id){
        return orderRepository.getOrderLengthByCategoryId(id);
    }

    //get all size order by searching key
    public long getOrderSizeByKey(String key){
        return orderRepository.getOrderSizeByKey(key);
    }


    /*
    public List<Order> getAllOrders(int page,int size){

        Pageable pageable = PageRequest.of(page,size);
        return orderRepository.findAll(pageable).getContent();

    public List<Order> getOrdersByIdCategories(Long id,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return orderRepository.findByCategoryId(id,pageable).getContent();
    }

    public List<Order> getOrdersByKey(String key,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return orderRepository.findByNameContaining(key,pageable).getContent();
    }

    public Order getOrder(Long id){
        return orderRepository.findById(id).get();
    }

    public long getAllOrdersSize(){
        return orderRepository.count();
    }

    public long getOrdersByCategoryIdLength(Long id){
        return orderRepository.getOrderLengthByCategoryId(id);
    }

    public long getOrderSizeByKey(String key){
        return orderRepository.getOrderSizeByKey(key);
    }
    }*/

}
