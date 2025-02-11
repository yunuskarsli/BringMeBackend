package com.example.demo.Specifications;

import com.example.demo.Filter.UserCommentsFilter;
import com.example.demo.entity.UserComments;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;



public class UserCommentsSpecification {

    public static Specification<UserComments> filter(UserCommentsFilter filter){
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getUsers() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("users"), filter.getUsers()));
            }
//            if (filter.getTrade() != null) {
//                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("trade"), filter.getTrade()));
//            }
            if (filter.getComment_() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("comment"), filter.getComment_()));

            }
            if (filter.getCreatedAt()!=null){
                predicate=criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("createdAt"),filter.getCreatedAt()));
            }
            return predicate;
            };


        }
    }

