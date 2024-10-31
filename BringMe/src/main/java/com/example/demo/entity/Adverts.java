package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "advert")
@Entity
@Data

public class Adverts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToMany
    @JoinTable(
            name = "advert_request",
            joinColumns = @JoinColumn(name = "advert_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id")
    )
    private List<Request> requests = new ArrayList<>();

    private String fromCountry;
    private String toCountry;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private String description;
    private LocalDateTime createdDate;
}
