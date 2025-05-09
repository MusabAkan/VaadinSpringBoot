package com.musakan.core.service;

import com.musakan.core.dataAccess.CustomerRepository;
import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public BaseRepository<Customer> findRepository() {
        return customerRepository;
    }
}
