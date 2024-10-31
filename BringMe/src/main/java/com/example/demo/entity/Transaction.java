package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "transaction_request",  // Bağlantı tablosunun adı
            joinColumns = @JoinColumn(name = "transaction_id"),  // Transaction tablosunun foreign key'i
            inverseJoinColumns = @JoinColumn(name = "request_id")  // Request tablosunun foreign key'i
    )
    private List<Request> requests;  // Talep listesi
    private Integer amount;
    private String payment_method;
    private LocalDateTime transactions_date;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
