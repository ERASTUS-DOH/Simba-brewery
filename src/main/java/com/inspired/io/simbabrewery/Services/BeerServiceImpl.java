package com.inspired.io.simbabrewery.Services;

import com.inspired.io.simbabrewery.Models.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("GalaxyCat").beerStyle("Pale Ale").build();
    }
}
