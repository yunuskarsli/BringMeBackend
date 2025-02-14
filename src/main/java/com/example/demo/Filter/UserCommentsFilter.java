package com.example.demo.Filter;

//import com.example.demo.entity.Trade;
import com.example.demo.entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserCommentsFilter {
private Integer id;
private Users users;

//    private Trade trade;
    private String comment_;
    private LocalDateTime createdAt;
    public UserCommentsFilter(Integer id, Users users,  String comment_, LocalDateTime createdAt) {
        this.id = id;
        this.users = users;
//        this.trade = trade;
        this.comment_ = comment_;
        this.createdAt = createdAt;
    }


}
