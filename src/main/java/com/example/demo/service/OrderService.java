package com.example.demo.service;

import com.example.demo.entity.Orders;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;



    public ResponseEntity<List<Orders>> getAll(){
        List<Orders> Orders=orderRepository.findAll();
        return new ResponseEntity<>(Orders, HttpStatus.OK);
    }
    public ResponseEntity<Orders> save(Orders orders){
        Orders order=orderRepository.save(orders);
        return new ResponseEntity<>(orders,HttpStatus.CREATED);
    }
    public ResponseEntity<Orders> updateOrder(Orders orders){
        Orders order1=orderRepository.save(orders);
        if (order1!=null){
            return new ResponseEntity<>(order1,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(order1,HttpStatus.NOT_FOUND);
        }
    }
}
