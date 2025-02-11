package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
    @ManyToOne
    @JoinColumn(name = "advert_id", nullable = false)
    private Adverts adverts;
    private String orderKind;
    private String product;
    private Integer productPrice;
    private String fromCountry;
    private String toCountry;
    private Integer total;
    private Integer quantity;
    private LocalDateTime orderDate;
    private LocalDateTime bringingDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    private Transaction paymentMethod;



}