package com.example.demo.controller;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Request;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping("all")
    public ResponseEntity<List<Orders>> all(){
        return orderService.getAll();
    }
    @DeleteMapping("delete")
    public ResponseEntity<Orders> delete(@RequestBody Orders orders){
        orderRepository.delete(orders);
        return new ResponseEntity<>(orders, HttpStatus.NO_CONTENT);
    }
    @PostMapping("save")
    public ResponseEntity<Orders> save(@RequestBody Orders orders){
        return orderService.save(orders);
    }
    @PutMapping("update")
    public ResponseEntity<Orders> update(@RequestBody Orders orders){
        return orderService.updateOrder(orders);
    }
    @GetMapping("page")
    public Page<Orders> page(@RequestParam(defaultValue ="0" ) int page,
                            @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest= PageRequest.of(page,size);
        return orderRepository.findAll(pageRequest);
    }

}
