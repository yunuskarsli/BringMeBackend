package com.example.demo.service;

import com.example.demo.Filter.TransactionsFilter;
import com.example.demo.Specifications.TransactionsSpecification;
import com.example.demo.entity.Request;
import com.example.demo.entity.Transactions;
import com.example.demo.entity.UserComments;
import com.example.demo.entity.Users;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserCommentsRepository userCommentsRepository;


    public ResponseEntity<List<Transactions>> getAll(){
        List<Transactions> transactions=transactionRepository.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    public ResponseEntity<Transactions> update(Transactions transaction) {
        Transactions transaction1 = transactionRepository.save(transaction);

        if (transaction1 != null) {
            return new ResponseEntity<>(transaction1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(transaction1, HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Transactions> save(Transactions transaction){
        Transactions transaction1=transactionRepository.save(transaction);

//
//        System.out.println("Kaydedilen Transactions: " + transaction1);
//
//        // Request kontrolü
//        Request request = transaction1.getRequest();
//        if (request == null) {
//            throw new RuntimeException(" Request bilgisi eksik! Transactions kaydedilemedi.");
//        }
//        System.out.println("Request: " + request);
//
//        // Request içindeki kullanıcı bilgisi kontrolü
//        Users user = request.getUsers();
//        if (user == null) {
//            throw new RuntimeException(" Users bilgisi eksik! Transactions kaydedilemedi.");
//        }
//        System.out.println("User: " + user);

        UserComments userComments = new UserComments();
        userComments.setComment_(transaction1.getComments());
        userComments.setCreatedAt(transaction1.getCreated_at() != null ? transaction1.getCreated_at() : LocalDateTime.now());
        userComments.setUsers(transaction1.getRequest().getUsers());


        // UserComments kaydet
        userCommentsRepository.save(userComments);



//
//        UserComments userComments=new UserComments();
//        userComments.setComment_(transaction1.getComments());
//        userComments.setCreatedAt(transaction1.getCreated_at());
//        userComments.setUsers(transaction1.getRequest().getUsers());
//        userCommentsRepository.save(userComments);



        return new ResponseEntity<>(transaction1,HttpStatus.CREATED);
    }
    public List<Transactions> getByFilter(TransactionsFilter filter){
        return transactionRepository.findAll(TransactionsSpecification.filter(filter));
    }
}
