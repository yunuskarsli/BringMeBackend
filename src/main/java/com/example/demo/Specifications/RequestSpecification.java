package com.example.demo.Specifications;

import com.example.demo.entity.Request;
import com.example.demo.Filter.RequestFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class RequestSpecification {
    public static Specification<Request> requestFilter(RequestFilter filter){
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getProductName() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("productName"), filter.getProductName()));
            }
            if (filter.getProductPrice() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("productPrrice"), filter.getProductPrice()));
            }
            if (filter.getQuantity() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("quantity"), filter.getQuantity()));
            }
            if (filter.getStatus() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status"), filter.getStatus()));
            }
            if (filter.getDeliveryFee() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("deliveryFree"), filter.getDeliveryFee()));
            }
            if (filter.getCreatedAt() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("createdAt"), filter.getCreatedAt()));
            }
            if (filter.getTotalCost() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("totalCost"), filter.getTotalCost()));
            }
            if (filter.getUpdatedAt() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("updatedAt"), filter.getUpdatedAt()));
            }
            return predicate;
        };
    }
}
