package com.example.demo.Specifications;

import com.example.demo.Filter.UserFilter;
import com.example.demo.entity.Users;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecificaiton {
    public static Specification<Users> filter(UserFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getUsername() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("username"), filter.getUsername()));
            }
            if (filter.getSurname() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("surname"), filter.getSurname()));
            }
            if (filter.getRole() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("role"), filter.getRole()));
            }
            if (filter.getEmail() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("email"), filter.getEmail()));
            }
            if (filter.getCreated_at() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("created_at"), filter.getCreated_at()));
            }
            if (filter.getPassword() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("password"), filter.getPassword()));
            }
            return predicate;
        };

    }
}
