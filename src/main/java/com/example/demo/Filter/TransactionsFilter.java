package com.example.demo.Filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionsFilter {
    private Integer id;
    private Integer amount;
    private String payment_method;
    private LocalDateTime transactions_date;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public TransactionsFilter(Integer id, Integer amount, String payment_method, LocalDateTime transactions_date,
                              LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.amount = amount;
        this.payment_method = payment_method;
        this.transactions_date = transactions_date;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    public TransactionsFilter(){

    }
}
