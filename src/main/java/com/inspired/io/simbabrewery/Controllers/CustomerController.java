package com.inspired.io.simbabrewery.Controllers;

import com.inspired.io.simbabrewery.Models.CustomerDto;
import com.inspired.io.simbabrewery.Services.CustomerService;
import com.inspired.io.simbabrewery.Services.CustomerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    public CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto>  getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
}
