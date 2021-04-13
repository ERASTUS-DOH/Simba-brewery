package com.inspired.io.simbabrewery.Services;

import com.inspired.io.simbabrewery.Models.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImp implements CustomerService{
    @Override
    public CustomerDto getCustomerById(UUID customerId){
        return CustomerDto.builder().id(UUID.randomUUID()).firstName("Erastus").lastName("Mercy").middleName("Elinam").build();
    }
}
