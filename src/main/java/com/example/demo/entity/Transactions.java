package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request_id;

    private Integer amount;
    private String paymentMethod;
    private LocalDateTime transactions_date;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String comments;
}
