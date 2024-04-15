package com.pw.dockercomposedemo.repository;

import com.pw.dockercomposedemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
