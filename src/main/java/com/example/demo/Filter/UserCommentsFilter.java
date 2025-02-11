package com.example.demo.Filter;

import com.example.demo.entity.Orders;
import com.example.demo.entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserCommentsFilter {
private Integer id;
private Users users;

    private Orders orders;
    private String comment;
    private LocalDateTime createdAt;
    public UserCommentsFilter(Integer id, Users users, Orders orders, String comment, LocalDateTime createdAt) {
        this.id = id;
        this.users = users;
        this.orders = orders;
        this.comment = comment;
        this.createdAt = createdAt;
    }


}
