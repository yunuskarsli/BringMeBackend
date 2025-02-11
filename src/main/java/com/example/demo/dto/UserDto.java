package com.example.demo.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDto {
    private Integer id;
    private String username;
    private String surname;

    public UserDto(){

    }
}
