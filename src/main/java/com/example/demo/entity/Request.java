package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "adverts_id")
    private Advert adverts;
    private String productName;
    private Integer productPrice;
    private Integer quantity;
    private Integer deliveryFee;
    private Integer totalCost;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
