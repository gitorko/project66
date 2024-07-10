package com.demo.project66.repository;

import com.demo.project66.domain.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
