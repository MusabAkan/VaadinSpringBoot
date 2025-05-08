package com.musakan.core.business.abstracts;

import com.musakan.core.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {
    void add(Customer customer);

    List<Customer> findAll();
}
