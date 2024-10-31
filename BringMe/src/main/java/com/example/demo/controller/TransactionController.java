package com.example.demo.controller;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    public TransactionService transactionService;

    @GetMapping("all")
    public ResponseEntity<List<Transaction>> getAll(@RequestBody Transaction transaction){
       return transactionService.getAll();
    }
    @DeleteMapping("delete")
    public ResponseEntity<Transaction> delete(@RequestBody Transaction transaction){
         transactionRepository.delete(transaction);
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("update")
    public ResponseEntity<Transaction> update(@RequestBody Transaction transaction){
        return transactionService.update(transaction);
    }
    @PostMapping("save")
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction){
        return transactionService.save(transaction);
    }
    @GetMapping("page")
    public Page<Transaction> getTransactions(@RequestParam (defaultValue = "0")int page,
                                             @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return transactionRepository.findAll(pageRequest);
    }


}
