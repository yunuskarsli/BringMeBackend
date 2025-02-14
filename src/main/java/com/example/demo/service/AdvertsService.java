package com.example.demo.service;

import com.example.demo.Specifications.AdvertsSpecification;
import com.example.demo.entity.Advert;
import com.example.demo.Filter.AdvertsFilter;
//import com.example.demo.entity.Trade;
import com.example.demo.entity.Trade;
import com.example.demo.entity.Users;
import com.example.demo.repository.AdvertsRepository;
//import com.example.demo.repository.TradeRepository;
import com.example.demo.repository.TradeRepository;
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
    private TradeRepository tradeRepository;
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<Advert> updateAdverts(Advert adverts){

        Advert adverts1=advertsRepository.save(adverts);

        if (adverts1!=null){
            return new ResponseEntity<>(adverts1,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<List<Advert>> getAll(){
        List<Advert> adverts=advertsRepository.findAll();
        return new ResponseEntity<>(adverts,HttpStatus.OK);
    }



    public ResponseEntity<Advert> save(Advert adverts){
        Advert adverts1=advertsRepository.save(adverts);

        Trade trade=new Trade();
        trade.setFromCountry(adverts1.getFromCountry());
        trade.setToCountry(adverts1.getToCountry());
        trade.setOrderDate(adverts1.getCreatedDate());
        trade.setDescription(adverts1.getDescription());
        trade.setCreadet_at(adverts1.getCreatedDate());
        trade.setAdverts(adverts1);

        trade.setOrderKind(null);
        trade.setProductPrice(null);
        trade.setTotals(null);
        trade.setQuantity(null);
        trade.setProduct(null);
        trade.setBringingDate(null);
        trade.setRequest(null);

        tradeRepository.save(trade);

        return new ResponseEntity<>(adverts1,HttpStatus.CREATED);
    }
    public List<Advert> getAdvertsByFilter(AdvertsFilter advertsFilter){
        return advertsRepository.findAll(AdvertsSpecification.filter(advertsFilter));
    }
}
