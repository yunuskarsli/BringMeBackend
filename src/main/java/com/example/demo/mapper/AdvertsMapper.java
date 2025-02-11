package com.example.demo.mapper;

import com.example.demo.dto.AdvertsDto;
import com.example.demo.entity.Advert;

public class AdvertsMapper {

    public static AdvertsDto mapToAdvertsDto(Advert adverts){
        AdvertsDto advertsDto=new AdvertsDto();
        advertsDto.setId(adverts.getId());
        advertsDto.setToCountry(adverts.getToCountry());
        advertsDto.setFromCountry(adverts.getFromCountry());
        return advertsDto;
    }
    public static Advert mapToAdverts(AdvertsDto advertsDto){
       Advert adverts=new Advert();
       adverts.setId(advertsDto.getId());
       adverts.setToCountry(advertsDto.getToCountry());
       adverts.setFromCountry(advertsDto.getFromCountry());
       return adverts;
    }
}
