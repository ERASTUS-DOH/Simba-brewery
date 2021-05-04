package com.inspired.io.simbabrewery.Controllers;

import com.inspired.io.simbabrewery.Configurations.DbSettings;
import com.inspired.io.simbabrewery.Models.BeerDto;
import com.inspired.io.simbabrewery.Services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    private DbSettings dbSettings;
    private Environment env;

    @Value("${greeting: Hello Elinam Doh}")
    private String message;

    @Value("${app.db.password}")
    private String dbDetails;

    @Value("${app.db.connection}")
    private List<String> mylist;

    @Value("#{${app.db.values}}")
    private Map<String ,String> values;



    private final BeerService beerService;

    public BeerController(DbSettings dbSettings, BeerService beerService, Environment env){
        this.dbSettings = dbSettings;
        this.beerService = beerService;
        this.env = env;
    }
    @GetMapping({"/envDetails"})
    public ResponseEntity<String> getEnvDetails(){
        return new ResponseEntity<>(this.env.toString(), HttpStatus.OK);
    }

   @GetMapping({"/greet"})
   public ResponseEntity<String> beerGreet(){
        return new ResponseEntity<>(this.message + this.dbDetails + this.mylist.get(1) + this.values + " " + dbSettings.getConnection(), HttpStatus.OK);
   }
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping // Post - create new beer
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto){
        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to url.
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteById(beerId);
    }
}
