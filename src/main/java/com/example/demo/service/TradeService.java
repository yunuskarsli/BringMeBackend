package com.example.demo.service;

import com.example.demo.entity.Trade;
import com.example.demo.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;



    public ResponseEntity<List<Trade>> getAll(){
        List<Trade> trade=tradeRepository.findAll();
        return new ResponseEntity<>(trade, HttpStatus.OK);
    }
    public ResponseEntity<Trade> save(Trade trade){
        Trade trade1=tradeRepository.save(trade);
        return new ResponseEntity<>(trade,HttpStatus.CREATED);
    }
    public ResponseEntity<Trade> updateOrder(Trade orders){
        Trade order1=tradeRepository.save(orders);
        if (order1!=null){
            return new ResponseEntity<>(order1,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(order1,HttpStatus.NOT_FOUND);
        }
    }
}
