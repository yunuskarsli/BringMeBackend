package com.example.demo.Filter;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestFilter {
    private Integer id;
    private String productName;
    private Integer productPrice;
    private Integer quantity;
    private Integer deliveryFee;
    private Integer totalCost;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RequestFilter(Integer id, String productName, Integer productPrice, Integer quantity, Integer deliveryFee, Integer totalCost, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.deliveryFee = deliveryFee;
        this.totalCost = totalCost;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public RequestFilter(){

    }
}
