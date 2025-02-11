package com.example.demo.Specifications;

import com.example.demo.entity.Adverts;
import com.example.demo.Filter.AdvertsFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class AdvertsSpecification {

    public static Specification<Adverts> filter(AdvertsFilter filter){
        return (root, query, criteriaBuilder) -> {

            Predicate  predicate=criteriaBuilder.conjunction();

            if (filter.getId()!=null){
                predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("id"),filter.getId()));
            }
            if (filter.getToCountry()!=null){
                predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("toCountry"),filter.getToCountry()));
            }
            if (filter.getFromCountry()!=null){
                predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("fromCountry"),filter.getFromCountry()));
            }
            if (filter.getDescription()!=null){
                predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("description"),filter.getDescription()));
            }
            if (filter.getDepartureDate()!=null){
                predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("departureDate"),filter.getDepartureDate()));
            }
            if(filter.getReturnDate()!=null){
                predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("returnDate"),filter.getReturnDate()));
            }
            if (filter.getCreatedDate()!=null){
                predicate =criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("createdDate"),filter.getCreatedDate()));
            }
            return predicate;
        };
    }
}
