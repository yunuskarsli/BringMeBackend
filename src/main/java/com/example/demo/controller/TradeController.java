package com.example.demo.controller;

import com.example.demo.entity.Trade;
import com.example.demo.repository.TradeRepository;
import com.example.demo.service.TradeService;

import com.example.demo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class TradeController {
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private TradeService tradeService;

    @GetMapping("all")
    public ResponseEntity<List<Trade>> all(){
        return tradeService.getAll();
    }
    @DeleteMapping("delete")
    public ResponseEntity<Trade> delete(@RequestBody Trade trade){
        tradeRepository.delete(trade);
        return new ResponseEntity<>(trade, HttpStatus.NO_CONTENT);
    }
    @PostMapping("save")
    public ResponseEntity<Trade> save(@RequestBody Trade trade){
        return tradeService.save(trade);
    }
    @PutMapping("update")
    public ResponseEntity<Trade> update(@RequestBody Trade trade){
        return tradeService.updateOrder(trade);
    }
    @GetMapping("page")
    public Page<Trade> page(@RequestParam(defaultValue ="0" ) int page,
                            @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest= PageRequest.of(page,size);
        return tradeRepository.findAll(pageRequest);
    }

}
