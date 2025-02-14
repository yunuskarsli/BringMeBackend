package com.example.demo.service;

import com.example.demo.Filter.UserFilter;
import com.example.demo.Specifications.UserSpecificaiton;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<List<Users>> getAll() {
        List<Users> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

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
    public List<Users> getByFilter(UserFilter filter){

        return userRepository.findAll(UserSpecificaiton.filter(filter));
    }


}
