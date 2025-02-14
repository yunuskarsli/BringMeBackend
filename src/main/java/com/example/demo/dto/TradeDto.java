package com.example.demo.dto;

import com.example.demo.entity.Advert;

import java.time.LocalDateTime;

public class TradeDto {
    private Advert adverts;
    private String fromCountry;
    private String toCountry;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private String description;
    private LocalDateTime createdDate;

}
