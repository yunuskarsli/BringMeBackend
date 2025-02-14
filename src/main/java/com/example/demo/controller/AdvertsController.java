package com.example.demo.controller;

import com.example.demo.Filter.AdvertsFilter;
import com.example.demo.entity.Advert;
import com.example.demo.entity.Users;
import com.example.demo.repository.AdvertsRepository;
import com.example.demo.service.AdvertsService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("adverts")
public class AdvertsController {
    @Autowired
    private AdvertsService advertsService;
    @Autowired
    private AdvertsRepository advertsRepository;

    @GetMapping("all")
    public ResponseEntity<List<Advert>> getAll(){
          return advertsService.getAll();
    }

    @PostMapping("save")
    public ResponseEntity<Advert> saved(@RequestBody Advert adverts){
        return advertsService.save(adverts);

    }
    @DeleteMapping("delete")
    public ResponseEntity<Advert> delete(@RequestBody Advert adverts){
         advertsRepository.delete(adverts);
         return new ResponseEntity<>(adverts, HttpStatus.NO_CONTENT);
    }
    @PutMapping("update")
    public ResponseEntity<Advert> update(@RequestBody Advert adverts){
        return advertsService.updateAdverts(adverts);

    }
    @GetMapping("page")
    public Page<Advert> getAdverts(@RequestParam (defaultValue = "0")int page,
                                    @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return advertsRepository.findAll(pageRequest);
    }
    @GetMapping("filter")
    public List<Advert> filter(@RequestParam(required = false) Integer id,
                                @RequestParam(required = false) Users users_id,
                                @RequestParam(required = false) String fromCountry,
                                @RequestParam(required = false) String toCountry,
                                @RequestParam(required = false) LocalDateTime departurDate,
                                @RequestParam(required = false) LocalDateTime returnDate,
                                @RequestParam(required = false) String description,
                                @RequestParam(required = false) LocalDateTime createdDate){
        AdvertsFilter advertsFilter=new AdvertsFilter();
        advertsFilter.setId(id);
        advertsFilter.setUsers_id(users_id);
        advertsFilter.setDepartureDate(departurDate);
        advertsFilter.setFromCountry(fromCountry);
        advertsFilter.setToCountry(toCountry);
        advertsFilter.setDescription(description);
        advertsFilter.setReturnDate(returnDate);
        advertsFilter.setCreatedDate(createdDate);
        return advertsService.getAdvertsByFilter(advertsFilter);
    }
}
