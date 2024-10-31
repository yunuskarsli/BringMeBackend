//package com.example.demo.service;
//
//
//import com.example.demo.entity.Messages;
//import com.example.demo.repository.MessagesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MessagesService {
//    @Autowired
//    private MessagesRepository messagesRepository;
//
//
//
//
//    public ResponseEntity<Messages> updateMessages(Messages messages){
//        Messages messages1=messagesRepository.save(messages);
//
//        if(messages1!=null){
//            return new ResponseEntity<>(messages1, HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(messages1,HttpStatus.NOT_FOUND);
//        }
//    }
//    public ResponseEntity<List<Messages>> getAll(){
//        List<Messages> messages=messagesRepository.findAll();
//        return new ResponseEntity<>(messages,HttpStatus.OK);
//    }
//    public ResponseEntity<Messages> save(Messages messages){
//        Messages messages1=messagesRepository.save(messages);
//    return  new ResponseEntity<>(messages,HttpStatus.CREATED);
//
//    }
//}
