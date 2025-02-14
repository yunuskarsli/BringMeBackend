package com.example.demo.controller;

import com.example.demo.Filter.TransactionsFilter;
import com.example.demo.entity.Transactions;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    public TransactionService transactionService;

    @GetMapping("all")
    public ResponseEntity<List<Transactions>> getAll(){
       return transactionService.getAll();
    }
    @DeleteMapping("delete")
    public ResponseEntity<Transactions> delete(@RequestBody Transactions transaction){
         transactionRepository.delete(transaction);
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("update")
    public ResponseEntity<Transactions> update(@RequestBody Transactions transaction){
        return transactionService.update(transaction);
    }
    @PostMapping("save")
    public ResponseEntity<Transactions> save(@RequestBody Transactions transaction){
        return transactionService.save(transaction);
    }
    @GetMapping("page")
    public Page<Transactions> getTransactions(@RequestParam (defaultValue = "0")int page,
                                             @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return transactionRepository.findAll(pageRequest);
    }
    @GetMapping("filter")
    public List<Transactions> getByFilter(@RequestParam(required = false) Integer id,
                                         @RequestParam(required = false)String payment_method,
                                         @RequestParam(required = false)Integer amount,

                                         @RequestParam(required = false)LocalDateTime transactions_date,
                                         @RequestParam(required = false)LocalDateTime created_at,
                                         @RequestParam(required = false)LocalDateTime updated_at){
        TransactionsFilter filter=new TransactionsFilter();
        filter.setId(id);
        filter.setAmount(amount);
        filter.setTransactions_date(transactions_date);
        filter.setPayment_method(payment_method);
        filter.setCreated_at(created_at);
        filter.setUpdated_at(updated_at);
        return transactionService.getByFilter(filter);
    }


}
