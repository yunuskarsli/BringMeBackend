package com.example.demo.Filter;

import com.example.demo.entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter

public class MessagesFilter {
    private Integer id;
    private Users receive_id;
    private Users sender_id;
    private String text;
    private LocalDateTime send_date;

    public MessagesFilter(Integer id, Users receive_id, Users sender_id, String text, LocalDateTime send_date) {
        this.id = id;
        this.receive_id = receive_id;
        this.sender_id = sender_id;
        this.text = text;
        this.send_date = send_date;
    }
    public MessagesFilter(){

    }


}
