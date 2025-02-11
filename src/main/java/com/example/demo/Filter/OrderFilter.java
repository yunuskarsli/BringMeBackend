package com.example.demo.Filter;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class OrderFilter {
    private Integer id;
    private Users request_id;
    private Users advert_id;
    private String orderKind;
    private String product;
    private Integer productPrice;
    private String fromCountry;
    private String toCountry;
    private Integer total;
    private Integer quantity;
    private LocalDateTime orderDate;
    private LocalDateTime bringingDate;
    private String description;
    private Transaction paymentMethod_id;

    public OrderFilter(Integer id, Users request_id, Users advert_id, String OrdersKind, String product, Integer productPrice, String fromCountry, String toCountry, Integer total, Integer quantity, LocalDateTime orderDate, LocalDateTime bringingDate, String description, Transaction paymentMethod_id) {
        this.id = id;
        this.request_id = request_id;
        this.advert_id = advert_id;
        this.orderKind = orderKind;
        this.product = product;
        this.productPrice = productPrice;
        this.fromCountry = fromCountry;
        this.toCountry = toCountry;
        this.total = total;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.bringingDate = bringingDate;
        this.description = description;
        this.paymentMethod_id = paymentMethod_id;
    }
}
