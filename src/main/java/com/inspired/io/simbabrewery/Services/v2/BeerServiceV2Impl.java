package com.inspired.io.simbabrewery.Services.v2;

import com.inspired.io.simbabrewery.Models.BeerDto;
import com.inspired.io.simbabrewery.Models.v2.BeerDtov2;
import com.inspired.io.simbabrewery.Models.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BeerServiceV2Impl implements BeerServiceV2{
    @Override
    public BeerDtov2 getBeerById(UUID beerId) {
        return BeerDtov2.builder().id(UUID
                .randomUUID())
                .beerName("GoldStrong")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }


    @Override
    public BeerDtov2 saveNewBeer(BeerDtov2 beerDtov2){
        return beerDtov2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtov2 beerDto) {
        //todo implement the update of a beer given an ID and the beerDto
    }

    @Override
    public void deleteById(UUID beerId) {
        //todo implement the delete of beer given an its ID.
    }
}
