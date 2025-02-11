package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
    private Integer id;
    private Integer amount;
    private String payment_method;

    public TransactionDto(){

    }
}
