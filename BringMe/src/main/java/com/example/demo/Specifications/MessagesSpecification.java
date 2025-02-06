package com.example.demo.Specifications;

import com.example.demo.Filter.MessagesFilter;
import com.example.demo.entity.Messages;
import jakarta.persistence.CacheRetrieveMode;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class MessagesSpecification {

    public static Specification<Messages> filter(MessagesFilter filter){
        return (root, query, criteriaBuilder) -> {

            Predicate predicate=criteriaBuilder.conjunction();

        if (filter.getId()!=null){
            predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("id"),filter.getId()));
        }
        if (filter.getReceive_id()!=null){
            predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("receive_id"),filter.getReceive_id()));

        }
        if (filter.getSender_id()!=null){
            predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("sender_id"),filter.getSender_id()));

        }
        if (filter.getText()!=null){
            predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("text"),filter.getText()));

        }if (filter.getSend_date()!=null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("send_date"), filter.getSend_date()));
            }
        return predicate;
        };
    }
}
