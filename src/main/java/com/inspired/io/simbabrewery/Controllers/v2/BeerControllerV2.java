package com.inspired.io.simbabrewery.Controllers.v2;

import com.inspired.io.simbabrewery.Models.BeerDto;
import com.inspired.io.simbabrewery.Models.v2.BeerDtov2;
import com.inspired.io.simbabrewery.Services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2){
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtov2> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // Post - create new beer
    public ResponseEntity handlePost(@RequestBody BeerDtov2 beerDtov2){
        BeerDtov2 savedDtov2 = beerServiceV2.saveNewBeer(beerDtov2);
        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url.
        headers.add("Location", "/api/v1/beer" + savedDtov2.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtov2 beerDtov2){
        beerServiceV2.updateBeer(beerId, beerDtov2);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteById(beerId);
    }
}
