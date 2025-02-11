package com.example.demo.mapper;

import com.example.demo.dto.RequestDto;
import com.example.demo.entity.Request;

public class RequestMapper {

    public static RequestDto mapToRequestDto(Request request){
        RequestDto requestDto=new RequestDto();
        requestDto.setId(request.getId());
        requestDto.setProductPrice(request.getProductPrice());
        requestDto.setProductName(request.getProductName());
        return requestDto;
    }
    public static  Request mapToRequest(RequestDto requestDto){
        Request request=new Request();
        request.setId(requestDto.getId());
        request.setProductPrice(requestDto.getProductPrice());
        request.setProductName(requestDto.getProductName());
        return  request;
    }
}
