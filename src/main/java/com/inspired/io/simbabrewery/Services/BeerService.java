package com.inspired.io.simbabrewery.Services;

import com.inspired.io.simbabrewery.Models.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId) ;


}
