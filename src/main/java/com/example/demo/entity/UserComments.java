package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.ToString;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_comments")
public class UserComments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn( name = "user_id",nullable = false)
    private Users users;
    @ManyToOne
    @JoinColumn(name = "Orders_id" ,nullable = false)
    private Orders orders;
    private String comment;
    private LocalDateTime createdAt;
}
