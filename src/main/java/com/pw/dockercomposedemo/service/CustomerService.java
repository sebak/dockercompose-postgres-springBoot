package com.pw.dockercomposedemo.service;

import com.pw.dockercomposedemo.model.Customer;
import com.pw.dockercomposedemo.model.dto.CreateCustomerDto;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    void createCustomer(CreateCustomerDto dto);
}
