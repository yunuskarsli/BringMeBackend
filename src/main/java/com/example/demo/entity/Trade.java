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
    @Column(nullable = true)

    private String orderKind;
    @Column(nullable = true)

    private String product;
    @Column(nullable = true)

    private Integer productPrice;
    @Column(nullable = true)

    private String fromCountry;
    @Column(nullable = true)

    private String toCountry;
    @Column(nullable = true)

    private Integer totals;
    @Column(nullable = true)

    private Integer quantity;
    @Column(nullable = true)

    private LocalDateTime orderDate;
    @Column(nullable = true)

    private LocalDateTime bringingDate;
    private  LocalDateTime creadet_at;
    @Column(nullable = true)

    private String description;
//    @OneToOne
//    @JoinColumn(name = "paymentMethod_id",nullable = true)
//    private Transactions paymentMethod;
}