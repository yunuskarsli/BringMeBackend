//package com.example.demo.controller;
//
//import com.example.demo.entity.Messages;
//import com.example.demo.repository.MessagesRepository;
//import com.example.demo.service.MessagesService;
//import jakarta.persistence.Table;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.parameters.P;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("messages")
//public class MessagesController {
//
//    @Autowired
//    private MessagesRepository messagesRepository;
//    @Autowired
//    private MessagesService messagesService;
//
//    @GetMapping("all")
//    public ResponseEntity<List<Messages>> getAll(@RequestBody Messages messages){
//        return messagesService.getAll();
//    }
//    @DeleteMapping("delete")
//    public ResponseEntity<Messages> delete(@RequestBody Messages messages){
//        messagesRepository.delete(messages);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    @PostMapping("save")
//    public ResponseEntity<Messages> save(@RequestBody Messages messages){
//        return messagesService.save(messages);
//    }
//    @PutMapping("update")
//    public ResponseEntity<Messages> update(@RequestBody Messages messages){
//        return messagesService.updateMessages(messages);
//    }
//
//}
