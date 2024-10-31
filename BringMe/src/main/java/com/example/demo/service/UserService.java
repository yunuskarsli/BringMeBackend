package com.example.demo.service;

import com.example.demo.entity.Adverts;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<List<Users>> getAll() {
        List<Users> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

//    public ResponseEntity<Users> deleteUsers(@RequestBody Users users){
//        userRepository.delete(users);
//        return new ResponseEntity<>(users,HttpStatus.NO_CONTENT);
//    }
    public ResponseEntity<Users> updateUser(Users users){
        Users updateUser=userRepository.save(users);
        if(updateUser !=null){
            return new ResponseEntity<>(updateUser,HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>((HttpStatus.NOT_FOUND));

        }


    }
    public ResponseEntity<Users> save(Users users){
        Users  users1=userRepository.save(users);
        return new ResponseEntity<>(users,HttpStatus.CREATED);
    }


}
