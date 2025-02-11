package com.example.demo.Specifications;

import com.example.demo.Filter.TradeFilter;
import com.example.demo.entity.Trade;
import com.example.demo.entity.Transactions;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class TradeSpecification {

    public static Specification<Trade> filter(TradeFilter filter) {
        return (root, query, criteriaBuilder) -> {

            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getToCountry() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("toCountry"), filter.getToCountry()));
            }
            if (filter.getFromCountry() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("fromCountry"), filter.getFromCountry()));
            }
            if (filter.getDescription() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("description"), filter.getDescription()));
            }
            if (filter.getAdvert_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("advert_id"), filter.getAdvert_id()));
            }
            if (filter.getOrderDate() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("orderDate"), filter.getOrderDate()));
            }
            if (filter.getBringingDate() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("bringingDate"), filter.getBringingDate()));
            }
            if (filter.getOrderKind() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("orderKind"), filter.getOrderKind()));
            }
            if (filter.getProduct() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("product"), filter.getProduct()));
            }
            if (filter.getProductPrice() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("productPrice"), filter.getProductPrice()));
            }
            if (filter.getPaymentMethod_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("paymentMethod_id"), filter.getPaymentMethod_id()));
            }
            if (filter.getQuantity() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("quantity"), filter.getQuantity()));
            }
            if (filter.getRequest_id() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("request_id"), filter.getRequest_id()));
            }
            if (filter.getTotals() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("total"), filter.getTotals()));
            }
            return predicate;
        };
    }
}