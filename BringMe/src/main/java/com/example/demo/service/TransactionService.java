package com.example.demo.service;

import com.example.demo.Filter.TransactionsFilter;
import com.example.demo.Specifications.TransactionsSpecification;
import com.example.demo.controller.TransactionController;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.temporal.Temporal;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;


    public ResponseEntity<List<Transaction>> getAll(){
        List<Transaction> transactions=transactionRepository.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    public ResponseEntity<Transaction> update(Transaction transaction) {
        Transaction transaction1 = transactionRepository.save(transaction);

        if (transaction1 != null) {
            return new ResponseEntity<>(transaction1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(transaction1, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Transaction> save(Transaction transaction){
        Transaction transaction1=transactionRepository.save(transaction);
        return new ResponseEntity<>(transaction1,HttpStatus.CREATED);
    }
    public List<Transaction> getByFilter(TransactionsFilter filter){
        return transactionRepository.findAll(TransactionsSpecification.filter(filter));
    }
}
