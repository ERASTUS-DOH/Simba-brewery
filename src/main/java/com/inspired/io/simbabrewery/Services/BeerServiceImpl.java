package com.inspired.io.simbabrewery.Services;

import com.inspired.io.simbabrewery.Models.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("GalaxyCat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //todo implement the update of a beer given an ID and the beerDto
    }

    @Override
    public void deleteById(UUID beerId) {
        //todo implement the delete of beer given an its ID.
        log.debug("Deleting the beer.");
    }
}
