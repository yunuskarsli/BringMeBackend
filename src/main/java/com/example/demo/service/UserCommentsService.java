package com.example.demo.service;

import com.example.demo.entity.UserComments;
import com.example.demo.repository.UserCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentsService {
    @Autowired
    private UserCommentsRepository userCommentsRepository;
    @Autowired
    private UserCommentsService userCommentsService;

    public ResponseEntity<List<UserComments>> getAll(){
        List<UserComments> userComments=userCommentsRepository.findAll();
        return new ResponseEntity<>(userComments, HttpStatus.OK);
    }
    public ResponseEntity<UserComments> update(UserComments userComments){
        UserComments userComments1=userCommentsRepository.save(userComments);
        if (userComments!=null){
            return new ResponseEntity<>(userComments,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<UserComments> save(UserComments userComments){
        UserComments userComments1=new UserComments();
        return new ResponseEntity<>(userComments1,HttpStatus.CREATED);
    }
}
