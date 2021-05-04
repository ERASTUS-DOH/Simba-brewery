package com.inspired.io.simbabrewery.Services.v2;

import com.inspired.io.simbabrewery.Models.BeerDto;
import com.inspired.io.simbabrewery.Models.v2.BeerDtov2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtov2 getBeerById(UUID beerId) ;


    BeerDtov2 saveNewBeer(BeerDtov2 beerDtov2);

    void updateBeer(UUID beerId, BeerDtov2 beerDtov2);

    void deleteById(UUID beerId);
}
