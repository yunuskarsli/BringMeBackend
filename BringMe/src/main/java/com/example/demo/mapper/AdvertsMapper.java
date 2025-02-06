package com.example.demo.mapper;

import com.example.demo.dto.AdvertsDto;
import com.example.demo.entity.Adverts;

public class AdvertsMapper {

    public static AdvertsDto mapToAdvertsDto(Adverts adverts){
        AdvertsDto advertsDto=new AdvertsDto();
        advertsDto.setId(adverts.getId());
        advertsDto.setToCountry(adverts.getToCountry());
        advertsDto.setFromCountry(adverts.getFromCountry());
        return advertsDto;
    }
    public static Adverts mapToAdverts(AdvertsDto advertsDto){
       Adverts adverts=new Adverts();
       adverts.setId(advertsDto.getId());
       adverts.setToCountry(advertsDto.getToCountry());
       adverts.setFromCountry(advertsDto.getFromCountry());
       return adverts;
    }
}
