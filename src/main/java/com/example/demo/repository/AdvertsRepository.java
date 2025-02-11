package com.example.demo.repository;

import com.example.demo.entity.Advert;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  AdvertsRepository  extends JpaRepository<Advert ,Long>    {
    List<Advert> findAll(Specification<Advert> specification);


}
