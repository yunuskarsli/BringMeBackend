package com.example.demo.Filter;

import com.example.demo.entity.Transactions;
import com.example.demo.entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class TradeFilter {
    private Integer id;
    private Users request_id;
    private Users advert_id;
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
    private Transactions paymentMethod_id;

    public TradeFilter(Integer id, Users request_id, Users advert_id, String OrdersKind, String product, Integer productPrice, String fromCountry, String toCountry, Integer totals, Integer quantity, LocalDateTime orderDate, LocalDateTime bringingDate, String description, Transactions paymentMethod_id) {
        this.id = id;
        this.request_id = request_id;
        this.advert_id = advert_id;
        this.orderKind = orderKind;
        this.product = product;
        this.productPrice = productPrice;
        this.fromCountry = fromCountry;
        this.toCountry = toCountry;
        this.totals = totals;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.bringingDate = bringingDate;
        this.description = description;
        this.paymentMethod_id = paymentMethod_id;
    }
}
