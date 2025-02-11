package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.CustomLog;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert adverts;
    private String orderKind;
    private String product;
    private Integer productPrice;
    private String fromCountry;
    private String toCountry;
    private Integer totals;
    private Integer quantity;
    private LocalDateTime orderDate;
    private LocalDateTime bringingDate;
    private String description;
    @OneToOne
    @JoinColumn(name = "paymentMethod_id",nullable = false)
    private Transactions paymentMethod;
}