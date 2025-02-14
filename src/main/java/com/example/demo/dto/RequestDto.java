package com.example.demo.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    private Integer id;
    private String productName;
    private Integer productPrice;

    public RequestDto(){

    }
}
