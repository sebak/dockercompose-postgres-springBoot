package com.pw.dockercomposedemo.service.impl;

import com.pw.dockercomposedemo.model.Customer;
import com.pw.dockercomposedemo.model.dto.CreateCustomerDto;
import com.pw.dockercomposedemo.repository.CustomerRepository;
import com.pw.dockercomposedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(CreateCustomerDto dto) {

        if (ObjectUtils.isEmpty(dto)) {
            throw new IllegalArgumentException("customer is empty");
        }
        Customer customer = Customer.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();

        customerRepository.save(customer);

    }
}
