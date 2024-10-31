package com.example.demo.controller;

import com.example.demo.entity.Adverts;
import com.example.demo.entity.Users;
import com.example.demo.repository.AdvertsRepository;
import com.example.demo.service.AdvertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "adverts")

public class AdvertsController {
    @Autowired
    private AdvertsService advertsService;
    @Autowired
    private AdvertsRepository advertsRepository;


    @GetMapping("all")
    public ResponseEntity<List<Adverts>> getAll() {
        return advertsService.getAll();
    }

    @PutMapping("update")
    public ResponseEntity<Adverts> updateAdverts(@RequestBody Adverts adverts){
        return advertsService.updateAdverts(adverts);
    }


    @DeleteMapping("delete")
    public ResponseEntity<Adverts> deleteAdverts(@RequestBody Adverts adverts){
        advertsRepository.delete(adverts);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("save")
    public ResponseEntity<Adverts> save(@RequestBody Adverts adverts){
        return advertsService.save(adverts);
    }
    @GetMapping("page")
    public Page<Adverts> getAdverts(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest= PageRequest.of(page,size);
        return advertsRepository.findAll(pageRequest);

    }

}
