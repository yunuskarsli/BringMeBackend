package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;



@Entity
@Data
@Table(name = "advert")

public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
    private String fromCountry;
    private String toCountry;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private String description;
    private LocalDateTime createdDate;
}
