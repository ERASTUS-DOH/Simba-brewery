package com.inspired.io.simbabrewery.Services;

import com.inspired.io.simbabrewery.Models.BeerDto;
import com.inspired.io.simbabrewery.Models.v2.BeerDtov2;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId) ;


    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
