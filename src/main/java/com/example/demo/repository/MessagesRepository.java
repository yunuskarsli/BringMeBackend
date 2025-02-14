package com.example.demo.repository;

import com.example.demo.entity.Messages;
import com.example.demo.entity.Request;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Messages ,Long> {
    List<Messages> findAll(Specification<Messages> specification);


}
