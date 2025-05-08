package com.musakan.core.dataAccess.abstracts;

import com.musakan.core.entities.concretes.Customer;

import java.util.List;

public interface CustomerDao {
    void add(Customer customer);
    void update(Customer customer);
    void delete (Customer customer);
    Customer findById(long id);
    List<Customer> findAll();
}
