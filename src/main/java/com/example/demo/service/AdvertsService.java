package com.example.demo.service;

import com.example.demo.Specifications.AdvertsSpecification;
import com.example.demo.entity.Adverts;
import com.example.demo.Filter.AdvertsFilter;
import com.example.demo.entity.Orders;
import com.example.demo.repository.AdvertsRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdvertsService {

    @Autowired
    private AdvertsRepository advertsRepository;
    @Autowired
    private OrderRepository ordersRepository;
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<Adverts> updateAdverts(Adverts adverts){

        Adverts adverts1=advertsRepository.save(adverts);

        if (adverts1!=null){
            return new ResponseEntity<>(adverts1,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<Adverts>> getAll(){
        List<Adverts> adverts=advertsRepository.findAll();
        return new ResponseEntity<>(adverts,HttpStatus.OK);
    }



    public ResponseEntity<Adverts> save(Adverts adverts){
        Adverts adverts1=advertsRepository.save(adverts);

        Orders orders=new Orders();
        orders.setFromCountry(adverts1.getFromCountry());
        orders.setToCountry(adverts1.getToCountry());
        orders.setOrderDate(adverts1.getCreatedDate());
        orders.setDescription(adverts1.getDescription());
        ordersRepository.save(orders);

        return new ResponseEntity<>(adverts1,HttpStatus.CREATED);
    }
    public List<Adverts> getAdvertsByFilter(AdvertsFilter advertsFilter){
        return advertsRepository.findAll(AdvertsSpecification.filter(advertsFilter));
    }
}
