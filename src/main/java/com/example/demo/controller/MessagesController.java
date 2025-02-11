package com.example.demo.controller;

import com.example.demo.Filter.MessagesFilter;
import com.example.demo.entity.Messages;
import com.example.demo.entity.Users;
import com.example.demo.repository.MessagesRepository;
import com.example.demo.service.MessagesService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("messages")
public class MessagesController {

    @Autowired
    private MessagesRepository messagesRepository;
    @Autowired
    private MessagesService messagesService;

    @GetMapping("all")
    public ResponseEntity<List<Messages>> getAll(){
        List<Messages> messages=messagesRepository.findAll();
        return new ResponseEntity<>(messages,HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Messages> delete(@RequestBody Messages messages){
        messagesRepository.delete(messages);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("save")
    public ResponseEntity<Messages> save(@RequestBody Messages messages){
        return messagesService.save(messages);
    }
    @PutMapping("update")
    public ResponseEntity<Messages> update(@RequestBody Messages messages){
        return messagesService.updateMessages(messages);
    }
    @GetMapping("filter")
    public List<Messages>       filter(@RequestParam(required = false) Integer id,
                                       @RequestParam(required = false)Users receive_id,
                                       @RequestParam(required = false)Users sender_id,
                                       @RequestParam(required = false)String text,
                                       @RequestParam(required = false)LocalDateTime send_date){
        MessagesFilter messagesFilter=new MessagesFilter();
        messagesFilter.setId(id);
        messagesFilter.setText(text);
        messagesFilter.setSend_date(send_date);
        messagesFilter.setSender_id(sender_id);
        messagesFilter.setReceive_id(receive_id);
        return messagesService.getMessagesByFilter(messagesFilter);

    }

}
