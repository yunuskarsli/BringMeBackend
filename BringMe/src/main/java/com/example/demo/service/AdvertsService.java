package com.example.demo.service;

import com.example.demo.entity.Adverts;
import com.example.demo.entity.Users;
import com.example.demo.repository.AdvertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class AdvertsService {

    @Autowired
    private AdvertsRepository advertsRepository;


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
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Adverts> save(Adverts adverts){
        Adverts adverts1=advertsRepository.save(adverts);
        return new ResponseEntity<>(adverts1,HttpStatus.CREATED);
    }
}
