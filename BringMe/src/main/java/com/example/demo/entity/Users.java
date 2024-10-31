package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "user_request", // Ara tablonun adı
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id")
    )
    private List<Request> requests = new ArrayList<>();
    private String username;
    private String surname;
    private String email;
    private Integer password;
    private String role;
    private Date created_at;

}
