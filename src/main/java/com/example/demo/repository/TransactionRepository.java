package com.example.demo.repository;

import com.example.demo.entity.Transactions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions ,Integer> {
    List<Transactions> findAll(Specification<Transactions > specification);
}
