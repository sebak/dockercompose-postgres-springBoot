package com.pw.dockercomposedemo.controller;

import com.pw.dockercomposedemo.model.Customer;
import com.pw.dockercomposedemo.model.dto.CreateCustomerDto;
import com.pw.dockercomposedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("BONJOUR ET TEST");
    }

    /*
    when object like Customer is return, we may make sure that we have implemented her getter and setter to avoid to have empty bracket like this [{},{}]
     */
    @GetMapping(value= "/customers",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCustomerDto> createCustomer(CreateCustomerDto dto) {
        customerService.createCustomer(dto);
        return ResponseEntity.ok(dto);
    }
}
