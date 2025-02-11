package com.example.demo.service;

import com.example.demo.Specifications.RequestSpecification;
import com.example.demo.entity.Request;
import com.example.demo.Filter.RequestFilter;
//import com.example.demo.entity.Trade;
//import com.example.demo.repository.TradeRepository;
import com.example.demo.entity.Trade;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.TradeRepository;
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
    private TradeRepository tradeRepository;

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

        Trade trade=new Trade();
        trade.setProduct(request.getProductName());
        trade.setProductPrice(request.getProductPrice());
        trade.setTotals(request.getTotalCost());
        trade.setOrderDate(request.getCreatedAt());
        trade.setQuantity(request.getQuantity());
        tradeRepository.save(trade);


    return new ResponseEntity<>(request1,HttpStatus.CREATED);
    }
    public List<Request> getRequestByFilter(RequestFilter requestFilter){
        return requestRepository.findAll(RequestSpecification.requestFilter(requestFilter));

    }
}
