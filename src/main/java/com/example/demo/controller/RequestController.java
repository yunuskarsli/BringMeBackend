package com.example.demo.controller;

//import com.example.demo.entity.Messages;
import com.example.demo.entity.Request;
import com.example.demo.Filter.RequestFilter;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("request")
public class RequestController {

    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Request>> getAll(){
        return requestService.getAll();
    }
    @GetMapping("page")
    public Page<Request> getRequest(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return requestRepository.findAll(pageRequest);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Request> delete(@RequestBody Request request){
        requestRepository.delete(request);
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);

    }
    @PutMapping("update")
    public ResponseEntity<Request> update(@RequestBody Request request){
        return requestService.updateRequest(request);
    }
    @PostMapping("save")
    public ResponseEntity<Request> save(@RequestBody Request request){
      return   requestService.save(request);
    }
    @GetMapping("filter")
    public List<Request> getRequestByFilter(@RequestParam(required = false)Integer id,
                                          @RequestParam(required = false)String productName,
                                          @RequestParam(required = false)Integer productPrice,
                                          @RequestParam(required = false)Integer quantty,
                                          @RequestParam(required = false)Integer deliveyfree,
                                          @RequestParam(required = false)Integer totalCost,
                                          @RequestParam(required = false)String status,
                                          @RequestParam(required = false)LocalDateTime createdAt,
                                          @RequestParam(required = false)LocalDateTime updatedAt){
        RequestFilter filter=new RequestFilter();
        filter.setId(id);
        filter.setProductName(productName);
        filter.setProductPrice(productPrice);
        filter.setQuantity(quantty);
        filter.setDeliveryFee(deliveyfree);
        filter.setTotalCost(totalCost);
        filter.setStatus(status);
        filter.setUpdatedAt(updatedAt);
        filter.setCreatedAt(createdAt);
        return requestService.getRequestByFilter(filter);
    }
}
