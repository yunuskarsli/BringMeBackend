package com.example.demo.Filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserFilter {
    private Integer id;
    private String username;
    private String surname;
    private String email;
    private Integer password;
    private String role;
    private LocalDateTime created_at;

    public UserFilter(Integer id, String username, String surname, String email, Integer password, String role, LocalDateTime created_at){
        this.id=id;
        this.username=username;
        this.surname=surname;
        this.email=email;
        this.password=password;
        this.created_at=created_at;
        this.role=role;

    }
    public UserFilter(){

    }
}
