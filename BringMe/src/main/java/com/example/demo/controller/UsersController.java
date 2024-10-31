package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UsersController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("page")
    public Page<Users> getUsers(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest= PageRequest.of(page,size);
        return userRepository.findAll(pageRequest);

    }

    @GetMapping("all")
    public ResponseEntity<List<Users>> getAll() {
        return userService.getAll();
    }


    @DeleteMapping("delete")
    public ResponseEntity<Users> deleteUser(@RequestBody Users users) {
        userRepository.delete(users);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("update")
    public ResponseEntity<Users> updateUser(@RequestBody Users users) {
        return userService.updateUser(users);
    }


    @PostMapping("save")
    public ResponseEntity<Users> save(@RequestBody Users users) {
        return userService.save(users);
    }


}
