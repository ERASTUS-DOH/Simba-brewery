package com.inspired.io.simbabrewery.Services;

import com.inspired.io.simbabrewery.Models.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImp implements CustomerService{
    @Override
    public CustomerDto getCustomerById(UUID customerId){
        return CustomerDto.builder().id(UUID.randomUUID()).firstName("Erastus").lastName("Mercy").middleName("Elinam").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return customerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        //todo implement an update for the customer given the customer and id
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting a user........");
    }
}
