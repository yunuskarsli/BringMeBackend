package com.example.demo.repository;

import com.example.demo.entity.Adverts;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  AdvertsRepository  extends JpaRepository<Adverts ,Long>    {


}
