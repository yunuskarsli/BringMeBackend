//package com.example.demo.entity;
//
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Table(name = "Messages")
//@Data
//@Entity
//public class Messages {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer id;
//    @ManyToMany
//    @JoinColumn(name = "users" ,referencedColumnName = "id")
//    private Users senderId;
//    @ManyToMany
//    @JoinColumn(name = "users" , referencedColumnName = "id")
//    private Users receiverId;
//    private String text;
//    private LocalDateTime sendDate;
//}
