package com.example.demo.controller;

import com.example.demo.entity.UserComments;
import com.example.demo.repository.UserCommentsRepository;
import com.example.demo.service.UserCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

    @RestController
    @RequestMapping("user_comments")
    public class UserCommentsController {
        @Autowired
        private UserCommentsRepository userCommentsRepository;
        @Autowired
        private UserCommentsService userCommentsService;

        @GetMapping("all")
        public ResponseEntity<List<UserComments>> all(){
            return userCommentsService.getAll();
        }
        @DeleteMapping("delete")
        public ResponseEntity<UserComments> delete(@RequestBody UserComments userComments){
            userCommentsRepository.delete(userComments);
            return new ResponseEntity<>(userComments, HttpStatus.NO_CONTENT);
        }
        @PostMapping("save")
        public ResponseEntity<UserComments> save(@RequestBody UserComments userComments){
            return userCommentsService.save(userComments);
        }
        @PutMapping("update")
        public ResponseEntity<UserComments> update(@RequestBody UserComments userComments){
            return userCommentsService.update(userComments);
        }
        @GetMapping("page")
        public Page<UserComments> page(@RequestParam(defaultValue ="0" ) int page,
                                @RequestParam(defaultValue = "5") int size){
            PageRequest pageRequest= PageRequest.of(page,size);
            return userCommentsRepository.findAll(pageRequest);
        }

    }

