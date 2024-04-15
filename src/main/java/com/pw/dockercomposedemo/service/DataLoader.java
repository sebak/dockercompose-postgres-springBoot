package com.pw.dockercomposedemo.service;

import com.pw.dockercomposedemo.model.Customer;
import com.pw.dockercomposedemo.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {

    private final CustomerRepository customerRepository;

    @Autowired
    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Fill database when application is loaded
     */
    @PostConstruct
    public void init() {
        customerRepository.saveAll(List.of(Customer.builder().firstName("Peter").lastName("Bayebeck").build(),
                Customer.builder().firstName("Alain").lastName("Mbock").build()));
    }
}
