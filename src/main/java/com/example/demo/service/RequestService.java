package com.example.demo.service;

import com.example.demo.Specifications.RequestSpecification;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Request;
import com.example.demo.Filter.RequestFilter;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<List<Request>> getAll(){
        List<Request> requests=requestRepository.findAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }
    public ResponseEntity<Request> updateRequest(Request request){
        Request request1= requestRepository.save(request);
        if (request1!=null){
            return new ResponseEntity<>(request1,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(request1,HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Request> save(Request request){
    Request request1=requestRepository.save(request);

        Orders orders=new Orders();
        orders.setProduct(request.getProductName());
        orders.setProductPrice(request.getProductPrice());
        orders.setTotal(request.getTotalCost());
        orders.setOrderDate(request.getCreatedAt());
        orders.setQuantity(request.getQuantity());
        orderRepository.save(orders);


    return new ResponseEntity<>(request1,HttpStatus.CREATED);
    }
    public List<Request> getRequestByFilter(RequestFilter requestFilter){
        return requestRepository.findAll(RequestSpecification.requestFilter(requestFilter));

    }
}
