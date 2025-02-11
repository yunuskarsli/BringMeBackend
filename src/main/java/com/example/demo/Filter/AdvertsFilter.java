package com.example.demo.Filter;

import com.example.demo.entity.Users;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AdvertsFilter {
    private Integer id;
    private Users users_id;
    private String fromCountry;
    private String toCountry;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private String description;
    private LocalDateTime createdDate;

    public AdvertsFilter(Integer id, Users user_id, String fromCountry, String toCountry, LocalDateTime departureDate, LocalDateTime returnDate, String description, LocalDateTime createdDate) {
        this.id = id;
        this.users_id=user_id;
        this.fromCountry = fromCountry;
        this.toCountry = toCountry;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.description = description;
        this.createdDate = createdDate;
    }
    public AdvertsFilter(){

    }
}
