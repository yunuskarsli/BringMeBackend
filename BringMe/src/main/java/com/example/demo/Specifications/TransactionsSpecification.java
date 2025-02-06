package com.example.demo.Specifications;

import com.example.demo.Filter.TransactionsFilter;
import com.example.demo.entity.Transaction;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;




public class TransactionsSpecification {
    public static Specification<Transaction> filter(TransactionsFilter filter){
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getAmount() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("amount"), filter.getAmount()));
            }
            if (filter.getPayment_method() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("payment_method"), filter.getPayment_method()));

            }
            if (filter.getCreated_at() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("created_at"), filter.getCreated_at()));

            }
            if (filter.getTransactions_date() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("transactions_date"), filter.getTransactions_date()));

            }
            if (filter.getUpdated_at() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("updated_at"), filter.getUpdated_at()));
            }
            return predicate;
};
    }}
