package com.inspired.io.simbabrewery.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inspired.io.simbabrewery.Models.BeerDto;
import com.inspired.io.simbabrewery.Services.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.print.attribute.standard.Media;
import java.util.UUID;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

//@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)

public class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    BeerDto validBeer;


    @BeforeEach
    public void setUp() {
       validBeer = BeerDto.builder()
               .id(UUID.randomUUID())
               .beerName("Club")
               .beerStyle("Pale_Ale")
               .upc(new Long(12345678))
               .build();
    }

    @Test
    public void testGetBeer() throws Exception{
        given(beerService.getBeerById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//                .andExpect(jsonPath("$.id",is(validBeer.getId().toString())))
//                .andExpect(jsonPath("$.beerName", is("Club")));

    }
}