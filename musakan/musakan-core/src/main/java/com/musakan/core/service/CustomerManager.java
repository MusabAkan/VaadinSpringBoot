package com.musakan.core.service;

import com.musakan.core.dataAccess.CustomerRepository;
import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.Customer;
import com.musakan.core.service.base.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager extends BaseManager<Customer> implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    protected BaseRepository<Customer> getRepository() {
        return customerRepository;
    }
}


