package com.example.demo.repository;

import com.example.demo.entity.Transaction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction ,Integer> {
    List<Transaction> findAll(Specification<Transaction > specification);
}
